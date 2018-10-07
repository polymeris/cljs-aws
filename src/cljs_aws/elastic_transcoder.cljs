(ns cljs-aws.elastic-transcoder
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ElasticTranscoder" "elastictranscoder-2012-09-25.min.json")
