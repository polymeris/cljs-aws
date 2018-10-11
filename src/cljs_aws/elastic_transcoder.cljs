(ns cljs-aws.elastic-transcoder
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ElasticTranscoder" "elastictranscoder-2012-09-25.min.json")
