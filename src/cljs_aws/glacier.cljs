(ns cljs-aws.glacier
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Glacier" "glacier-2012-06-01.min.json")
