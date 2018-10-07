(ns cljs-aws.ses
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "SES" "email-2010-12-01.min.json")
