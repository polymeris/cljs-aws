(ns cljs-aws.health
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Health" "health-2016-08-04.min.json")
