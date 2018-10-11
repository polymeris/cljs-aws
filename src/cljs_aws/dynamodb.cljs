(ns cljs-aws.dynamodb
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "DynamoDB" "dynamodb-2012-08-10.min.json")
