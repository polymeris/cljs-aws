(ns cljs-aws.elb-v2
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ELBv2" "elasticloadbalancingv2-2015-12-01.min.json")
