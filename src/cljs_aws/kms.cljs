(ns cljs-aws.kms
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "KMS" "kms-2014-11-01.min.json")
