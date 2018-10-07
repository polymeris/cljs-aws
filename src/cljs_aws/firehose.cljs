(ns cljs-aws.firehose
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Firehose" "firehose-2015-08-04.min.json")
