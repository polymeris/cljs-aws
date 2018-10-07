(ns cljs-aws.cognito-sync
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CognitoSync" "cognito-sync-2014-06-30.min.json")
