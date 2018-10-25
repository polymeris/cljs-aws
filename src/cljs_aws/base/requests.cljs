(ns cljs-aws.base.requests
  (:require [cljs-aws.base.config :as config]
            [camel-snake-kebab.core :refer [->PascalCaseString ->kebab-case-keyword ->camelCaseString]]
            [camel-snake-kebab.extras :refer [transform-keys]]
            [cljs.core.async :as a]))

(defn- perform-request!
  [service-name operation-name params callback]
  (.makeRequest (config/service service-name) operation-name (clj->js params) callback))

(defn- prepare-params [params]
  (transform-keys #(if (keyword? %) (->PascalCaseString %) %) params))

(defn- handle-response [err data]
  (->> (if err {:error (str err)} (js->clj data))
       (transform-keys ->kebab-case-keyword)))

(defn request
  "Perform a request to AWS services.

   Returns a core.async channel, on which the result will be put, or `{:error \"message\"}`
   on error"
  [service-name operation-name params]
  (let [ch (a/chan)]
    (perform-request! service-name
                      operation-name
                      (prepare-params params)
                      (fn [err data]
                        (a/put! ch (handle-response err data))
                        (a/close! ch)))
    ch))
