(ns cljs-aws.sts
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "STS" "sts-2011-06-15.min.json")
