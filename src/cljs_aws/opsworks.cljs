(ns cljs-aws.opsworks
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "OpsWorks" "opsworks-2013-02-18.min.json")
