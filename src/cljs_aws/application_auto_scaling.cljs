(ns cljs-aws.application-auto-scaling
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ApplicationAutoScaling" "application-autoscaling-2016-02-06.min.json")
