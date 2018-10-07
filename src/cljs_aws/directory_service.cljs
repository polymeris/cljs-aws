(ns cljs-aws.directory-service
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "DirectoryService" "ds-2015-04-16.min.json")
