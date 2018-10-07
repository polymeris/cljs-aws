(ns cljs-aws.sts
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "STS" "sts-2011-06-15.min.json")
