(ns cljs-aws.waf
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "WAF" "waf-2015-08-24.min.json")
