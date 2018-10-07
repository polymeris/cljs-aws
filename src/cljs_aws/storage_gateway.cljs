(ns cljs-aws.storage-gateway
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "StorageGateway" "storagegateway-2013-06-30.min.json")
