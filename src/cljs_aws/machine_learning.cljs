(ns cljs-aws.machine-learning
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "MachineLearning" "machinelearning-2014-12-12.min.json")
