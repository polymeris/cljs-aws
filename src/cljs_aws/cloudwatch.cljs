(ns cljs-aws.cloudwatch
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudWatch" "monitoring-2010-08-01.min.json")
