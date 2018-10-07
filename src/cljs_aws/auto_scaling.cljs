(ns cljs-aws.auto-scaling
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "AutoScaling" "autoscaling-2011-01-01.min.json")
