(ns cljs-aws.sns-example
  (:require [cljs-aws.sns :as sns]
            [cljs.core.async :refer [go <!]]
            [cljs-aws.examples-util :as util :refer [throw-or-print]]))

(enable-console-print!)

(defn -main
  "Example cljs script using cljs-aws."
  [& args]
  (go
    (util/override-endpoint-with-env)
    (let [topic-arn (-> (<! (sns/create-topic {:name "my-topic"}))
                        (throw-or-print)
                        :topic-arn)
          subscription-arn (-> (<! (sns/subscribe
                                     {:protocol  "lambda"
                                      :topic-arn topic-arn
                                      :endpoint  "arn:aws:lambda:us-east-1:676820690883:function:my-function"}))
                               (throw-or-print)
                               :subscription-arn)]
      (throw-or-print (<! (sns/list-topics)))
      (throw-or-print (<! (sns/list-subscriptions)))
      (throw-or-print (<! (sns/publish {:topic-arn          topic-arn
                                        :subject            "test"
                                        :message            (str "Todays is " (js/Date.))
                                        :message-attributes {"attr" {:data-type    "string"
                                                                     :string-value "value"}}})))
      (throw-or-print (<! (sns/unsubscribe {:subscription-arn subscription-arn}))))))

(set! *main-cli-fn* -main)