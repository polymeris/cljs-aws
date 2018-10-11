(ns cljs-aws.health
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Health" "health-2016-08-04.min.json")
