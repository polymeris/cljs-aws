(ns cljs-aws.organizations
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Organizations" "organizations-2016-11-28.min.json")
