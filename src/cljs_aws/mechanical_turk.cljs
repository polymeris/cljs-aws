(ns cljs-aws.mechanical-turk
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "MTurk" "mturk-requester-2017-01-17.min.json")
