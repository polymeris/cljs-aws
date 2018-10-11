(ns cljs-aws.step-functions
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "StepFunctions" "states-2016-11-23.min.json")
