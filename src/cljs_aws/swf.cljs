(ns cljs-aws.swf
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "SWF" "swf-2012-01-25.min.json")
