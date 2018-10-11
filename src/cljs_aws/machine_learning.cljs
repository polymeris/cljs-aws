(ns cljs-aws.machine-learning
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "MachineLearning" "machinelearning-2014-12-12.min.json")
