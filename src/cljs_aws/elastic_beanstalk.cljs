(ns cljs-aws.elastic-beanstalk
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "ElasticBeanstalk" "elasticbeanstalk-2010-12-01.min.json")
