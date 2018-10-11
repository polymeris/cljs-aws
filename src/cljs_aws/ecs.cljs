(ns cljs-aws.ecs
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ECS" "ecs-2014-11-13.min.json")
