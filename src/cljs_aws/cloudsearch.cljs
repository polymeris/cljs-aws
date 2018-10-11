(ns cljs-aws.cloudsearch
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CloudSearch" "cloudsearch-2013-01-01.min.json")
