(ns cljs-aws.s3-example
  (:require [cljs-aws.s3 :as s3]
            [cljs.core.async :refer [go <!]]))

(enable-console-print!)

(defn -main
  "Example cljs script using cljs-aws.
   Fetches a list of buckets from S3, then the objects contained in the first bucket.
   Set your credentials before executing."
  [& args]
  (go
    (let [first-bucket-name (-> (<! (s3/list-buckets {}))
                                :buckets
                                (first)
                                :name)
          object-keys (->> (<! (s3/list-objects-v2 {:bucket first-bucket-name}))
                           :contents
                           (map :key))]
      (println object-keys))))

(set! *main-cli-fn* -main)