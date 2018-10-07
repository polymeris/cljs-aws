(ns cljs-aws.cloudtrail
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudTrail" "cloudtrail-2013-11-01.min.json")
