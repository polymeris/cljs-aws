(ns cljs-aws.codepipeline
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CodePipeline" "codepipeline-2015-07-09.min.json")
