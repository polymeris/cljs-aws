(ns cljs-aws.iot
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Iot" "iot-2015-05-28.min.json")
