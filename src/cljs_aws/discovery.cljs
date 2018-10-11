(ns cljs-aws.discovery
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Discovery" "discovery-2015-11-01.min.json")
