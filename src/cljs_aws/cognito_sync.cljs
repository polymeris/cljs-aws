(ns cljs-aws.cognito-sync
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CognitoSync" "cognito-sync-2014-06-30.min.json")
