(ns cljs-aws.codedeploy
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CodeDeploy" "codedeploy-2014-10-06.min.json")
