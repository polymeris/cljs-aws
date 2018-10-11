(ns cljs-aws.service-catalog
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ServiceCatalog" "servicecatalog-2015-12-10.min.json")
