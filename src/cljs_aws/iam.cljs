(ns cljs-aws.iam
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "IAM" "iam-2010-05-08.min.json")
