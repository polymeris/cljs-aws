(ns cljs-aws.dynamodb-streams
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "DynamoDBStreams" "streams.dynamodb-2012-08-10.min.json")
