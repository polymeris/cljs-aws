(ns cljs-aws.application-auto-scaling
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ApplicationAutoScaling" "application-autoscaling-2016-02-06.min.json")
