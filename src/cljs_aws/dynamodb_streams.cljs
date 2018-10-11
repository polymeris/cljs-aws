(ns cljs-aws.dynamodb-streams
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "DynamoDBStreams" "streams.dynamodb-2012-08-10.min.json")
