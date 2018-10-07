(ns cljs-aws.device-farm
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "DeviceFarm" "devicefarm-2015-06-23.min.json")
