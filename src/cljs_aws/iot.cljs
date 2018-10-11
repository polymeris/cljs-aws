(ns cljs-aws.iot
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Iot" "iot-2015-05-28.min.json")
