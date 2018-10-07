(ns cljs-aws.cognito-identity
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CognitoIdentity" "cognito-identity-2014-06-30.min.json")
