(ns cljs-aws.elasticache
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ElastiCache" "elasticache-2015-02-02.min.json")
