(ns cljs-aws.mechanical-turk
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "MTurk" "mturk-requester-2017-01-17.min.json")
