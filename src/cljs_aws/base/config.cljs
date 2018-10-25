(ns cljs-aws.base.config
  (:require [aws-sdk]
            [camel-snake-kebab.core :refer [->PascalCaseString]]
            [camel-snake-kebab.extras :refer [transform-keys]]))

; js/AWS for the browser, require for node
(def ^:private aws (if (exists? js/AWS) js/AWS (js/require "aws-sdk")))

(defn- raw-service
  [service-name]
  (new (aget aws service-name)))

(def ^:no-doc service
  (memoize raw-service))

(defn- update-config! [key value]
  (.update (aget aws "config")
           (clj->js {key value})))

(defn set-region!
  "Manually set AWS region.

   Prefer using environment variables."
  [region]
  (update-config! "region" region))

(defn set-endpoint!
  "Override the AWS endpoint.

   Useful for testing."
  [endpoint]
  (update-config! "endpoint" endpoint))

(defn load-credentials!
  "Load credentials from the given provider.

   E.g.
   ```
   (load-credentials! :shared-ini-file-credentials {:profile \"personal\"})
   ```
   Other providers include `:cognito-identity-credentials` and `:web-identity-credentials`"
  [provider params]
  (let [provider (if (keyword? provider) (aget aws (->PascalCaseString provider)) provider)]
    (->> (transform-keys ->PascalCaseString params)
         (clj->js)
         (new provider)
         (update-config! "credentials"))))
