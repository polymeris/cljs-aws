(ns cljs-aws.opsworks-cm
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "OpsWorksCM" "opsworkscm-2016-11-01.min.json")
