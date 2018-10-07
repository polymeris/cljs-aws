(ns cljs-aws.efs
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "EFS" "elasticfilesystem-2015-02-01.min.json")
