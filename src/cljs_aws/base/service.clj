(ns cljs-aws.base.service
  (:require [camel-snake-kebab.core :refer [->kebab-case-string ->kebab-case-keyword ->camelCaseString]]
            [camel-snake-kebab.extras :refer [transform-keys]]
            [clojure.data.json :as json]))

(defn- sdk-operation-name
  [operation-name]
  (->camelCaseString operation-name))

(defn- fn-sym
  [operation-name]
  (-> operation-name
      (->kebab-case-string)
      (clojure.string/replace #"-v-(\d+)$" (fn [[_ v]] (str "-v" v))) ; replace -v-2 endings with -v2
      (symbol)))

(defn- doc-params
  [operation what]
  (let [params (-> operation what)
        required (->> (:required params)
                      (map ->kebab-case-keyword)
                      (set))
        member-strings (->> params :members keys sort
                            (map #(str % (if (required %) " †"))))
        member-strings (if (empty? member-strings) ["(none)"] member-strings)]
    (clojure.string/join ", " member-strings)))

(defn- doc-url
  [service-name operation-name]
  (str "https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/"
       service-name
       ".html#"
       (->camelCaseString operation-name)
       "-property"))

(defn- docstring
  [operation]
  (str "Parameters\n "
       (doc-params operation :input) "\n"
       "Outputs\n "
       (doc-params operation :output) "\n"
       (:doc-url operation)))

(defn- operation-data
  [service-name [operation-name operation]]
  (let [operation (assoc operation :service-name service-name
                                   :name operation-name
                                   :sdk-name (sdk-operation-name operation-name)
                                   :fn-sym (fn-sym operation-name)
                                   :doc-url (doc-url service-name operation-name))]
    (assoc operation :docstring (docstring operation))))

(defn service-operations
  "Given a service name corresponding to the name of the property of `AWS` and a file containing API specs,
   returns a list of operations.
   E.g, for `AWS.CodeCommit`:
       (service-operations \"CodeCommit\" \"codecommit-2015-04-13.min.json\")"
  [service-name api-file]
  (as-> (str "node_modules/aws-sdk/apis/" api-file) $
        (slurp $)
        (json/read-str $)
        (transform-keys ->kebab-case-keyword $)
        (get $ :operations)
        (map (partial operation-data service-name) $)))

(defn- operation-defn
  [{:keys [fn-sym sdk-name docstring service-name]}]
  `(defn ~fn-sym
     ~docstring
     [params#]
     (cljs-aws.base.requests/request ~service-name ~sdk-name params#)))

(defmacro defservice
  "Given a service name and a file containing API specs, generates functions corresponding to all of the
   service's operations.
   E.g, for `AWS.S3`:
       (defservice \"S3\" \"s3-2006-03-01.min.json\")
   Generates functions like:
       (list-buckets params)
       (put-object params)
   These functions all take a map as params and return an async channel, into which the result is put, if successful.
   In case of error, a `{:error \"message\"}` map is put, instead."
  [service-name api-file]
  `(do ~@(map operation-defn (service-operations service-name api-file))))
