(ns cljs-aws.emr
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "EMR" "elasticmapreduce-2009-03-31.min.json")
