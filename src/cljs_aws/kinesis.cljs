(ns cljs-aws.kinesis
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Kinesis" "kinesis-2013-12-02.min.json")
