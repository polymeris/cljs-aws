(ns cljs-aws.polly
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Polly" "polly-2016-06-10.min.json")
