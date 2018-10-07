(ns cljs-aws.glacier
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Glacier" "glacier-2012-06-01.min.json")
