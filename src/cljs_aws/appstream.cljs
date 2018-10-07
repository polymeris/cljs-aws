(ns cljs-aws.appstream
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "AppStream" "appstream-2016-12-01.min.json")
