(ns cljs-aws.simpledb
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "SimpleDB" "sdb-2009-04-15.min.json")
