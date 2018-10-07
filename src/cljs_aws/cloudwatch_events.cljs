(ns cljs-aws.cloudwatch-events
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudWatchEvents" "events-2015-10-07.min.json")
