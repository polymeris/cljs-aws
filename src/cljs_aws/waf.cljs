(ns cljs-aws.waf
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "WAF" "waf-2015-08-24.min.json")
