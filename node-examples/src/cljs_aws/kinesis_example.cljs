(ns cljs-aws.kinesis-example
  (:require [cljs-aws.kinesis :as kinesis]
            [cljs.core.async :refer [go <! timeout]]
            [cljs-aws.examples-util :as util :refer [throw-or-print]]))

(enable-console-print!)

(def stream-name "my-stream")

(defn -main
  "Example cljs script using cljs-aws."
  [& args]
  (go
    (util/override-endpoint-with-env)
    (throw-or-print (<! (kinesis/create-stream {:stream-name stream-name, :shard-count 1})))
    (throw-or-print (<! (kinesis/list-streams {})))
    (throw-or-print (<! (kinesis/describe-stream {:stream-name stream-name})))
    (println "Waiting for stream to be created...")
    (loop []
      (<! (timeout 3000))
      (let [stream-status (-> (<! (kinesis/describe-stream {:stream-name stream-name}))
                              :stream-description
                              :stream-status)]
        (println "Stream is" stream-status)
        (when (= stream-status "CREATING") (recur))))
    (throw-or-print (<! (kinesis/put-record {:stream-name   stream-name
                                             :data          "my data"
                                             :partition-key (str (random-uuid))})))
    (throw-or-print (<! (kinesis/put-records {:stream-name stream-name
                                              :records     [{:partition-key "x5h2ch", :data "foo"}
                                                            {:partition-key "x5j3ak", :data "quux"}]})))
    (let [shard-iterator (-> (<! (kinesis/get-shard-iterator {:stream-name         stream-name
                                                              :shard-id            "shardId-000000000000"
                                                              :shard-iterator-type "TRIM_HORIZON"}))
                             (throw-or-print)
                             :shard-iterator)]
      (throw-or-print (<! (kinesis/get-records {:shard-iterator shard-iterator}))))
    (throw-or-print (<! (kinesis/delete-stream {:stream-name stream-name})))))

(set! *main-cli-fn* -main)

