(ns cljs-aws.support
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Support" "support-2013-04-15.min.json")
