(ns cljs-aws.marketplace-metering
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "MarketplaceMetering" "meteringmarketplace-2016-01-14.min.json")
