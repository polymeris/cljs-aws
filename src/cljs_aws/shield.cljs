(ns cljs-aws.shield
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Shield" "shield-2016-06-02.min.json")
