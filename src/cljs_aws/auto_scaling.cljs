(ns cljs-aws.auto-scaling
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "AutoScaling" "autoscaling-2011-01-01.min.json")
