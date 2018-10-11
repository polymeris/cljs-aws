(ns cljs-aws.shield
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Shield" "shield-2016-06-02.min.json")
