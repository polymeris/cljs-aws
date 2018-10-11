(ns cljs-aws.s3-example
  (:require [cljs-aws.s3 :as s3]
            [cljs.core.async :refer [go <!]]
            [cljs-aws.examples-util :as util :refer [throw-or-print]]))

(enable-console-print!)

(defn -main
  "Example cljs script using cljs-aws.
   Fetches a list of buckets from S3, then the objects contained in the first bucket.
   Set your credentials before executing."
  [& args]
  (go
    (util/override-endpoint-with-env)
    (let [first-bucket-name (-> (<! (s3/list-buckets {}))
                                (throw-or-print)
                                :buckets
                                (first)
                                :name)
          object-keys (->> (<! (s3/list-objects-v2 {:bucket first-bucket-name}))
                           (throw-or-print)
                           :contents
                           (map :key))]
      (println "KEYS:" object-keys))))

(set! *main-cli-fn* -main)