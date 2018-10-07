(ns cljs-aws.dynamodb
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "DynamoDB" "dynamodb-2012-08-10.min.json")
