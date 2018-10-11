(ns cljs-aws.swf
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "SWF" "swf-2012-01-25.min.json")
