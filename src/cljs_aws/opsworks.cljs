(ns cljs-aws.opsworks
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "OpsWorks" "opsworks-2013-02-18.min.json")
