(ns cljs-aws.cur
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CUR" "cur-2017-01-06.min.json")
