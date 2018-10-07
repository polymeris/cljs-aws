(ns cljs-aws.config
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ConfigService" "config-2014-11-12.min.json")
