(ns cljs-aws.sqs
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "SQS" "sqs-2012-11-05.min.json")
