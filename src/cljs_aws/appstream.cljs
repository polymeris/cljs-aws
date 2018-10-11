(ns cljs-aws.appstream
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "AppStream" "appstream-2016-12-01.min.json")
