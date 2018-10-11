(ns cljs-aws.cloudhsm
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CloudHSM" "cloudhsm-2014-05-30.min.json")
