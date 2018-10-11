(ns cljs-aws.s3
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "S3" "s3-2006-03-01.min.json")
