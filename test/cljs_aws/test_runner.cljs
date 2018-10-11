(ns cljs-aws.test-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [cljs-aws.base.requests-test]
            [cljs-aws.services.dynamodb-test]
            [cljs-aws.services.s3-test]))

(doo-tests 'cljs-aws.base.requests-test
           'cljs-aws.services.dynamodb-test
           'cljs-aws.services.s3-test)
