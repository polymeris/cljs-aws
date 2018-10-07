(ns cljs-aws.cloudformation
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudFormation" "cloudformation-2010-05-15.min.json")
