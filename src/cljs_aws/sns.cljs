(ns cljs-aws.sns
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "SNS" "sns-2010-03-31.min.json")
