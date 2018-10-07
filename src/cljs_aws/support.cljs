(ns cljs-aws.support
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Support" "support-2013-04-15.min.json")
