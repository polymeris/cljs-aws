(ns cljs-aws.workspaces
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "WorkSpaces" "workspaces-2015-04-08.min.json")
