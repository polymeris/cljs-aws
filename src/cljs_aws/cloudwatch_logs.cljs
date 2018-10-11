(ns cljs-aws.cloudwatch-logs
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CloudWatchLogs" "logs-2014-03-28.min.json")
