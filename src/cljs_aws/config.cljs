(ns cljs-aws.config
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ConfigService" "config-2014-11-12.min.json")
