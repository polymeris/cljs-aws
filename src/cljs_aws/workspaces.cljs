(ns cljs-aws.workspaces
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "WorkSpaces" "workspaces-2015-04-08.min.json")
