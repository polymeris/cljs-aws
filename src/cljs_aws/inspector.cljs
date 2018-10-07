(ns cljs-aws.inspector
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Inspector" "inspector-2016-02-16.min.json")
