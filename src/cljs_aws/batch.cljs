(ns cljs-aws.batch
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Batch" "batch-2016-08-10.min.json")
