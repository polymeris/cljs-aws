(ns cljs-aws.ecs
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ECS" "ecs-2014-11-13.min.json")
