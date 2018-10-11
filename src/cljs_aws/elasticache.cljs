(ns cljs-aws.elasticache
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ElastiCache" "elasticache-2015-02-02.min.json")
