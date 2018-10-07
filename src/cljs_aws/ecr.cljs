(ns cljs-aws.ecr
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ECR" "ecr-2015-09-21.min.json")
