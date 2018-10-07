(ns cljs-aws.workdocs
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "WorkDocs" "workdocs-2016-05-01.min.json")
