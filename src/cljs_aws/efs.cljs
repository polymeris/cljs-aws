(ns cljs-aws.efs
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "EFS" "elasticfilesystem-2015-02-01.min.json")
