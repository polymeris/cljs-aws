(ns cljs-aws.api-gateway
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "APIGateway" "apigateway-2015-07-09.min.json")
