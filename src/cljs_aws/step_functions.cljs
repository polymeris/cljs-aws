(ns cljs-aws.step-functions
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "StepFunctions" "states-2016-11-23.min.json")
