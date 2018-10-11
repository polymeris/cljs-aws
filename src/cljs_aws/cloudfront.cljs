(ns cljs-aws.cloudfront
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "CloudFront" "cloudfront-2017-03-25.min.json")
