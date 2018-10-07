(ns cljs-aws.mobile-analytics
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "MobileAnalytics" "mobileanalytics-2014-06-05.min.json")
