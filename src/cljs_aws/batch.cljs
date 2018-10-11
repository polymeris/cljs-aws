(ns cljs-aws.batch
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Batch" "batch-2016-08-10.min.json")
