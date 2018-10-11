(ns cljs-aws.lightsail
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Lightsail" "lightsail-2016-11-28.min.json")
