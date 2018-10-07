(ns cljs-aws.lambda
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Lambda" "lambda-2015-03-31.min.json")
