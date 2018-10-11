(ns cljs-aws.device-farm
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "DeviceFarm" "devicefarm-2015-06-23.min.json")
