(ns cljs-aws.cognito-idp
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CognitoIdentityServiceProvider" "cognito-idp-2016-04-18.min.json")
