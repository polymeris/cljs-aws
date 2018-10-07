(ns cljs-aws.kms
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "KMS" "kms-2014-11-01.min.json")
