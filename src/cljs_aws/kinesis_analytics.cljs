(ns cljs-aws.kinesis-analytics
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "KinesisAnalytics" "kinesisanalytics-2015-08-14.min.json")
