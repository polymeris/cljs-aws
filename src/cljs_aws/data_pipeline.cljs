(ns cljs-aws.data-pipeline
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "DataPipeline" "datapipeline-2012-10-29.min.json")
