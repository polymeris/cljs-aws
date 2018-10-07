(ns cljs-aws.cloudsearch
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudSearch" "cloudsearch-2013-01-01.min.json")
