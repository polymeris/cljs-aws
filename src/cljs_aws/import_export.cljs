(ns cljs-aws.import-export
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ImportExport" "importexport-2010-06-01.min.json")
