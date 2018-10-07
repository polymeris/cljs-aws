(ns cljs-aws.s3-test
  (:require [clojure.test :refer [deftest is async]]
            [camel-snake-kebab.core :refer [->camelCaseString]]
            [cljs.core.async :as a]
            [cljs-aws.s3 :as s3])
  (:require-macros [cljs-aws.test-macros :refer [with-example-mocks]]))

(deftest examples--s3--ok
  (async done
    (a/go
      (with-example-mocks "S3" "s3-2006-03-01.examples.json"
        (is (= {}
               (a/<! (s3/abort-multipart-upload
                       {:bucket    "examplebucket"
                        :key       "bigobject"
                        :upload-id "xadcOB_7YPBOJuoFiQ9cz4P3Pe6FIZwO4f7wN93uHsNBEw97pl5eNwzExg0LAT2dUN91cOmrEQHDsP3WA60CEg--"}))))
        (is (= {:bucket   "acexamplebucket"
                :e-tag    "\"4d9031c7644d8081c2829f4ea23c55f7-2\""
                :key      "bigobject"
                :location "https://examplebucket.s3.amazonaws.com/bigobject"}
               (a/<! (s3/complete-multipart-upload
                       {:bucket           "examplebucket"
                        :key              "bigobject"
                        :multipart-upload {:parts [{:e-tag "\"d8c2eafd90c266e19ab9dcacc479f8af\"", :part-number "1"}
                                                   {:e-tag "\"d8c2eafd90c266e19ab9dcacc479f8af\"", :part-number "2"}]}
                        :upload-id        "7YPBOJuoFiQ9cz4P3Pe6FIZwO4f7wN93uHsNBEw97pl5eNwzExg0LAT2dUN91cOmrEQHDsP3WA60CEg--"}))))
        (is (= {:copy-object-result {:e-tag "\"6805f2cfc46c0f04559748bb039d69ae\"", :last-modified "2016-12-15T17:38:53.000Z"}}
               (a/<! (s3/copy-object {:bucket      "destinationbucket"
                                      :copy-source "/sourcebucket/HappyFacejpg"
                                      :key         "HappyFaceCopyjpg"}))))
        (is (= {:location "http://examplebucket.s3.amazonaws.com/"}
               (a/<! (s3/create-bucket {:bucket                      "examplebucket"
                                        :create-bucket-configuration {:location-constraint "eu-west-1"}}))))
        (done)))))