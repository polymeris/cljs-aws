(ns cljs-aws.kinesis
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Kinesis" "kinesis-2013-12-02.min.json")
