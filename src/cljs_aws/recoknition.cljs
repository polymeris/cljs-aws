(ns cljs-aws.recoknition
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Recoknition" "rekognition-2016-06-27.min.json")
