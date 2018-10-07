(ns cljs-aws.service-catalog
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ServiceCatalog" "servicecatalog-2015-12-10.min.json")
