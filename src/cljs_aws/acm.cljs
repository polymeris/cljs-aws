(ns cljs-aws.acm
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ACM" "acm-2015-12-08.min.json")
