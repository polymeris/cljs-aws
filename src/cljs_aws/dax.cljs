(ns cljs-aws.dax
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "DAX" "dax-2017-04-19.min.json")
