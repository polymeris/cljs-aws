(ns cljs-aws.es
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ES" "es-2015-01-01.min.json")
