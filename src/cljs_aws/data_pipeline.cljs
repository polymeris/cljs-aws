(ns cljs-aws.data-pipeline
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "DataPipeline" "datapipeline-2012-10-29.min.json")
