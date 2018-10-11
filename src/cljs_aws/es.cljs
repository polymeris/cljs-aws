(ns cljs-aws.es
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ES" "es-2015-01-01.min.json")
