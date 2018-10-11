(ns cljs-aws.lambda
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Lambda" "lambda-2015-03-31.min.json")
