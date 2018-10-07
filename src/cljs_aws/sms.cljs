(ns cljs-aws.sms
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "SMS" "sms-2016-10-24.min.json")
