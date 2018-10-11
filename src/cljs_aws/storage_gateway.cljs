(ns cljs-aws.storage-gateway
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "StorageGateway" "storagegateway-2013-06-30.min.json")
