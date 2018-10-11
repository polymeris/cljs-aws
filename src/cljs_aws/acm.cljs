(ns cljs-aws.acm
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ACM" "acm-2015-12-08.min.json")
