(ns cljs-aws.iam
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "IAM" "iam-2010-05-08.min.json")
