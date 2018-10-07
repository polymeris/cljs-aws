(ns cljs-aws.athena
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Athena" "athena-2017-05-18.min.json")
