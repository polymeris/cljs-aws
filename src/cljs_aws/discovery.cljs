(ns cljs-aws.discovery
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Discovery" "discovery-2015-11-01.min.json")
