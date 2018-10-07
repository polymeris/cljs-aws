(ns cljs-aws.s3
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "S3" "s3-2006-03-01.min.json")
