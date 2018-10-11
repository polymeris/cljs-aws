(ns cljs-aws.iot-data
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "IotData" "iot-data-2015-05-28.min.json")
