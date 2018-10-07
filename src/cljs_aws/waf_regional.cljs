(ns cljs-aws.waf-regional
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "WAFRegional" "waf-regional-2016-11-28.min.json")
