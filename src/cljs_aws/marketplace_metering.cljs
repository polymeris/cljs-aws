(ns cljs-aws.marketplace-metering
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "MarketplaceMetering" "meteringmarketplace-2016-01-14.min.json")
