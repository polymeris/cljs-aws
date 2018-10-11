(ns cljs-aws.requests
  (:require [cljs.nodejs :as nodejs]
            [cljsjs.aws-sdk-js]
            [camel-snake-kebab.core :refer [->PascalCaseString ->kebab-case-keyword ->camelCaseString]]
            [camel-snake-kebab.extras :refer [transform-keys]]
            [cljs.core.async :as a]))

; js/AWS for the browser, require for node
(def ^:private aws (if (exists? js/AWS) js/AWS (nodejs/require "aws-sdk")))

(defn- raw-service
  [service-name]
  (new (aget aws service-name)))

(def ^:private memoized-service
  (memoize raw-service))

(defn- perform-request!
  [service-name operation-name params callback]
  (.makeRequest (memoized-service service-name) operation-name (clj->js params) callback))

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

(defn- config []
  (.-config aws))

(defn credentials
  "Returns the current AWS credentials"
  []
  (let [creds (.-credentials (config))]
    {:access-key-id     (.-accessKeyId creds)
     :secret-access-key (.-secretAccessKey creds)}))

;; TODO more generic config/credentials handling

(defn set-region!
  [region]
  (aset (config) "region" region))

(defn set-cognito-identity!
  [identity-pool-id]
  (->> (clj->js {"IdentityPoolId" identity-pool-id})
       (new (.-CognitoIdentityCredentials aws))
       (aset (config) "credentials")))
