(ns cljs-aws.base.config
  (:require [cljsjs.aws-sdk-js]))

; js/AWS for the browser, require for node
(def ^:private aws (if (exists? js/AWS) js/AWS (js/require "aws-sdk")))

(defn- raw-service
  [service-name]
  (new (aget aws service-name)))

(def service
  (memoize raw-service))

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
