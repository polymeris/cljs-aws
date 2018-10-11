(ns cljs-aws.ec2
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "EC2" "ec2-2016-11-15.min.json")
