(ns cljs-aws.budgets
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Budgets" "budgets-2016-10-20.min.json")
