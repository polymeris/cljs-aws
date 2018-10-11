(ns cljs-aws.ses
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "SES" "email-2010-12-01.min.json")
