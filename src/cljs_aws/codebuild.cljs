(ns cljs-aws.codebuild
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CodeBuild" "codebuild-2016-10-06.min.json")
