(ns cljs-aws.emr
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "EMR" "elasticmapreduce-2009-03-31.min.json")
