(ns cljs-aws.kinesis-analytics
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "KinesisAnalytics" "kinesisanalytics-2015-08-14.min.json")
