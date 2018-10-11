(ns cljs-aws.cloudtrail
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CloudTrail" "cloudtrail-2013-11-01.min.json")
