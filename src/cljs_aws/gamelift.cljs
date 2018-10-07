(ns cljs-aws.gamelift
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "GameLift" "gamelift-2015-10-01.min.json")
