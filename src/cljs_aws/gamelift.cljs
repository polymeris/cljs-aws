(ns cljs-aws.gamelift
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "GameLift" "gamelift-2015-10-01.min.json")
