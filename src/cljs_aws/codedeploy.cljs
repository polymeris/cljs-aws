(ns cljs-aws.codedeploy
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CodeDeploy" "codedeploy-2014-10-06.min.json")
