(ns cljs-aws.test-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [cljs-aws.requests-test]
            [cljs-aws.dynamodb-test]
            [cljs-aws.s3-test]))

(doo-tests 'cljs-aws.requests-test
           'cljs-aws.dynamodb-test
           'cljs-aws.s3-test)
