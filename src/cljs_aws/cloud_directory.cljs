(ns cljs-aws.cloud-directory
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudDirectory" "clouddirectory-2016-05-10.min.json")
