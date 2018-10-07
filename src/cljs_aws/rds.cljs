(ns cljs-aws.rds
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "RDS" "rds-2014-10-31.min.json")
