(ns cljs-aws.ssm
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "SSM" "ssm-2014-11-06.min.json")
