(ns cljs-aws.cloudhsm
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudHSM" "cloudhsm-2014-05-30.min.json")
