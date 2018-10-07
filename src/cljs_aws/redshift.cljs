(ns cljs-aws.redshift
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "RedShift" "redshift-2012-12-01.min.json")
