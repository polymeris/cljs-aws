(ns cljs-aws.cloudwatch-example
  (:require [cljs-aws.cloudwatch :as cloudwatch]
            [cljs.core.async :refer [go <! timeout]]
            [cljs-aws.examples-util :as util :refer [throw-or-print]]))


(enable-console-print!)

(defn -main
  "Example cljs script using cljs-aws.
  Put metrics and get statistics from CloudWatch."
  [& args]
  (go
    (util/override-endpoint-with-env)
    (throw-or-print (<! (cloudwatch/put-metric-data
                          {:namespace   "test_namespace"
                           :metric-data [{:metric-name "test_metric"
                                          :unit        "Count"
                                          :value       1.0
                                          :dimensions  [{:name  "test_name"
                                                         :value "test_value"}]}]})))
    ; get-metric-data would be preferred, but was introduced in 2.221.1
    (throw-or-print (<! (cloudwatch/get-metric-statistics
                          {:start-time  "2018-10-10T00:00:00Z"
                           :end-time    "2018-10-11T00:00:00Z"
                           :period      3600
                           :metric-name "ProvisionedReadCapacityUnits"
                           :namespace   "AWS/DynamoDB"
                           :dimensions  [{:name  "TableName"
                                          :value "TestTable"}]
                           :unit        "Count"
                           :statistics  ["Sum"]})))))

(set! *main-cli-fn* -main)

