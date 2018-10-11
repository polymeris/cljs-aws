(ns cljs-aws.waf-regional
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "WAFRegional" "waf-regional-2016-11-28.min.json")
