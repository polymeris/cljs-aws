(ns cljs-aws.sms
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "SMS" "sms-2016-10-24.min.json")
