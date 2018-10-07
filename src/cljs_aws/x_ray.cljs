(ns cljs-aws.x-ray
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "XRay" "xray-2016-04-12.min.json")
