(ns cljs-aws.direct-connect
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "DirectConnect" "directconnect-2012-10-25.min.json")
