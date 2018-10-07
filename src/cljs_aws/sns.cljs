(ns cljs-aws.sns
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "SNS" "sns-2010-03-31.min.json")
