(ns cljs-aws.lex-runtime
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "LexRuntime" "runtime.lex-2016-11-28.min.json")
