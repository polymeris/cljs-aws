(ns cljs-aws.cloudfront
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "CloudFront" "cloudfront-2017-03-25.min.json")
