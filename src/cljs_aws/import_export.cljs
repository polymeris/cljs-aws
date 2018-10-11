(ns cljs-aws.import-export
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ImportExport" "importexport-2010-06-01.min.json")
