(ns cljs-aws.lightsail
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Lightsail" "lightsail-2016-11-28.min.json")
