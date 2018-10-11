(ns cljs-aws.lambda-example
  (:require [cljs-aws.base.requests :as requests]
            [cljs-aws.lambda :as lambda]
            [cljs.core.async :refer [go <!]]
            [dommy.core :as dommy :refer-macros [sel1]]))

(enable-console-print!)

(requests/set-region! "us-east-1")
(requests/set-cognito-identity! "EDIT_ME")

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