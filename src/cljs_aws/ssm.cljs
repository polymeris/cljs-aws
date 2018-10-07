(ns cljs-aws.ssm
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "SSM" "ssm-2014-11-06.min.json")
