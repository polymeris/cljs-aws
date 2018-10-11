(ns cljs-aws.elb-v2
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ELBv2" "elasticloadbalancingv2-2015-12-01.min.json")
