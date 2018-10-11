(ns cljs-aws.snowball
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Snowball" "snowball-2016-06-30.min.json")
