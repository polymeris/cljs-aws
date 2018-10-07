(ns cljs-aws.route-53
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Route53" "route53-2013-04-01.min.json")
