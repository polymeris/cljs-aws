(ns cljs-aws.codepipeline
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CodePipeline" "codepipeline-2015-07-09.min.json")
