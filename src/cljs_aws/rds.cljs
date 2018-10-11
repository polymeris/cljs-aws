(ns cljs-aws.rds
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "RDS" "rds-2014-10-31.min.json")
