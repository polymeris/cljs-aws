(ns cljs-aws.cognito-idp
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CognitoIdentityServiceProvider" "cognito-idp-2016-04-18.min.json")
