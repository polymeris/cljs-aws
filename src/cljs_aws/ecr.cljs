(ns cljs-aws.ecr
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ECR" "ecr-2015-09-21.min.json")
