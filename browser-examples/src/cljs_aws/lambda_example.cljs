(ns cljs-aws.lambda-example
  (:require [cljs-aws.base.config :as config]
            [cljs-aws.lambda :as lambda]
            [cljs.core.async :refer [go <!]]
            [dommy.core :as dommy :refer-macros [sel1]]))

(enable-console-print!)

(config/set-region! "us-east-1")
(config/load-credentials! :cognito-identity-credentials {:identity-pool-id "<ADD YOUR ID HERE>"})

(defn value-by-id [id]
  (-> (sel1 (str "#" id))
      (dommy/value)))

(defn set-output! [text]
  (dommy/set-text! (sel1 :#output) text))

(defn ^:export invoke-function []
  (go (let [response (<! (lambda/invoke {:function-name (value-by-id "function-name")
                                         :payload       (value-by-id "payload")}))
            error (:error response)]
        (if error (set-output! error)
                  (set-output! response)))))