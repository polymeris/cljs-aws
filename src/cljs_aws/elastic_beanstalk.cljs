(ns cljs-aws.elastic-beanstalk
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "ElasticBeanstalk" "elasticbeanstalk-2010-12-01.min.json")
