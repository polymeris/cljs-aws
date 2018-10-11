(ns cljs-aws.cognito-identity
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CognitoIdentity" "cognito-identity-2014-06-30.min.json")
