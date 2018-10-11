(ns cljs-aws.sqs
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "SQS" "sqs-2012-11-05.min.json")
