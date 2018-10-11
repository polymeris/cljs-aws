(ns cljs-aws.redshift
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "RedShift" "redshift-2012-12-01.min.json")
