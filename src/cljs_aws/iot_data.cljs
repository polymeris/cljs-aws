(ns cljs-aws.iot-data
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "IotData" "iot-data-2015-05-28.min.json")
