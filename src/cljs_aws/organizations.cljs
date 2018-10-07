(ns cljs-aws.organizations
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Organizations" "organizations-2016-11-28.min.json")
