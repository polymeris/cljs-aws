(ns cljs-aws.directory-service
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "DirectoryService" "ds-2015-04-16.min.json")
