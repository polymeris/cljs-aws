(ns cljs-aws.route-53
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Route53" "route53-2013-04-01.min.json")
