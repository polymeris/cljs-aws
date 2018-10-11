(ns cljs-aws.cloudwatch-events
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CloudWatchEvents" "events-2015-10-07.min.json")
