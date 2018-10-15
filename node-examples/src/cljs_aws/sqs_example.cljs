(ns cljs-aws.sqs-example
  (:require [cljs-aws.sqs :as sqs]
            [cljs.core.async :refer [go <!]]
            [cljs-aws.examples-util :as util :refer [throw-or-print]]))

(enable-console-print!)

(defn -main
  "Example cljs script using cljs-aws."
  [& args]
  (go
    (util/override-endpoint-with-env)
    (let [queue-url (-> (<! (sqs/create-queue {:queue-name "my-queue"
                                               :attributes {:visibility-timeout                "30"
                                                            :maximum-message-size              "65536"
                                                            :message-retention-period          "1209600"
                                                            :receive-message-wait-time-seconds "10"}}))
                        (throw-or-print)
                        :queue-url)]
      (throw-or-print (<! (sqs/list-queues)))
      (throw-or-print (<! (sqs/send-message {:queue-url queue-url :message-body "hello world"})))
      (throw-or-print (<! (sqs/receive-message {:queue-url queue-url})))
      (throw-or-print (<! (sqs/delete-queue {:queue-url queue-url}))))))

(set! *main-cli-fn* -main)
