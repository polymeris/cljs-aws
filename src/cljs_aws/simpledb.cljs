(ns cljs-aws.simpledb
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "SimpleDB" "sdb-2009-04-15.min.json")
