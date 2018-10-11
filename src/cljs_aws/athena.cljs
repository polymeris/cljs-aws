(ns cljs-aws.athena
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Athena" "athena-2017-05-18.min.json")
