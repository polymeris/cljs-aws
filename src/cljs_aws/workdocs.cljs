(ns cljs-aws.workdocs
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "WorkDocs" "workdocs-2016-05-01.min.json")
