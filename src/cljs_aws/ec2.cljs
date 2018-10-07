(ns cljs-aws.ec2
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "EC2" "ec2-2016-11-15.min.json")
