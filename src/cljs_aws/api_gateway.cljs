(ns cljs-aws.api-gateway
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "APIGateway" "apigateway-2015-07-09.min.json")
