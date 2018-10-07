(ns cljs-aws.codebuild
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CodeBuild" "codebuild-2016-10-06.min.json")
