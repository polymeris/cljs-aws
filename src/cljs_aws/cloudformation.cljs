(ns cljs-aws.cloudformation
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CloudFormation" "cloudformation-2010-05-15.min.json")
