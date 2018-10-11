(ns cljs-aws.cur
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CUR" "cur-2017-01-06.min.json")
