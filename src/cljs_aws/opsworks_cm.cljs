(ns cljs-aws.opsworks-cm
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "OpsWorksCM" "opsworkscm-2016-11-01.min.json")
