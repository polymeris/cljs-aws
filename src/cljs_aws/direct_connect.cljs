(ns cljs-aws.direct-connect
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "DirectConnect" "directconnect-2012-10-25.min.json")
