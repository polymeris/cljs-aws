(ns cljs-aws.cloudwatch-logs
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudWatchLogs" "logs-2014-03-28.min.json")
