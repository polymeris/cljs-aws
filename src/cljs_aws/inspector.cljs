(ns cljs-aws.inspector
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Inspector" "inspector-2016-02-16.min.json")
