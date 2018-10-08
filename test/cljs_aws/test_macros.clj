(ns cljs-aws.test-macros
  (:require [clojure.data.json :as json]
            [camel-snake-kebab.core :refer [->camelCaseString]]))

(defn- load-json
  [filename]
  (->> (slurp filename)
       (json/read-str)))

(defn- example-data [[operation examples] key]
  [(->camelCaseString operation) (get (first examples) key)])

(defn- example-mock-fn [service-name examples-file]
  (let [filename (str "node_modules/aws-sdk/apis/" examples-file)
        examples (get (load-json filename) "examples")
        inputs (into {} (map #(example-data % "input") examples))
        outputs (into {} (map #(example-data % "output") examples))
        operations (set (keys inputs))]
    `(fn [service-name# operation-name# params# callback#]
       (let [expected-input# (~inputs operation-name#)
             error# (cond
                      (not= service-name# ~service-name)
                      (str "Wrong service name " service-name#)

                      (not (~operations operation-name#))
                      (str "No mock for operation " operation-name#)

                      (not= params# expected-input#)
                      (str "Bad input to " operation-name#
                           ", got: " params#
                           ", expected: " expected-input#
                           ", difference: " (take 2 (clojure.data/diff params# expected-input#))))]
         (callback# error# (~outputs operation-name#))))))

(defmacro with-example-mocks
  "Evaluate body with cljs-aws.requests/perform-request! rebound to a mock implementation based on an examples file"
  [service-name examples-file & body]
  (let [mock-fn (example-mock-fn service-name examples-file)]
    `(with-redefs [~'cljs-aws.requests/perform-request! ~mock-fn]
       ~@body)))