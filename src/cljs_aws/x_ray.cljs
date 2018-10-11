(ns cljs-aws.x-ray
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "XRay" "xray-2016-04-12.min.json")
