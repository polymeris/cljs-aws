(ns cljs-aws.cloudwatch
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CloudWatch" "monitoring-2010-08-01.min.json")
