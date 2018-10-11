(ns cljs-aws.firehose
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Firehose" "firehose-2015-08-04.min.json")
