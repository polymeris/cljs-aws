(ns cljs-aws.snowball
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Snowball" "snowball-2016-06-30.min.json")
