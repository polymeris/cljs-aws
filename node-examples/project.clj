(defproject cljs-aws-node-examples :lein-v
  :description "Node examples for cljs-aws"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [org.clojure/core.async "0.4.474"]
                 [cljs-aws nil]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [com.roomkey/lein-v "6.3.0"]]
  :middleware [leiningen.v/version-from-scm
               leiningen.v/dependency-version-from-scm
               leiningen.v/add-workspace-data]
  :cljsbuild {:builds [{:id           "cloudwatch"
                        :source-paths ["src"]
                        :compiler     {:target    :nodejs
                                       :main      cljs-aws.cloudwatch-example
                                       :output-to "target/cloudwatch.js"}}
                       {:id           "dynamodb"
                        :source-paths ["src"]
                        :compiler     {:target    :nodejs
                                       :main      cljs-aws.dynamodb-example
                                       :output-to "target/dynamodb.js"}}
                       {:id           "kinesis"
                        :source-paths ["src"]
                        :compiler     {:target    :nodejs
                                       :main      cljs-aws.kinesis-example
                                       :output-to "target/kinesis.js"}}
                       {:id           "route-53"
                        :source-paths ["src"]
                        :compiler     {:target    :nodejs
                                       :main      cljs-aws.route-53-example
                                       :output-to "target/route-53.js"}}
                       {:id           "s3"
                        :source-paths ["src"]
                        :compiler     {:target    :nodejs
                                       :main      cljs-aws.s3-example
                                       :output-to "target/s3.js"}}
                       {:id           "sns"
                        :source-paths ["src"]
                        :compiler     {:target    :nodejs
                                       :main      cljs-aws.sns-example
                                       :output-to "target/sns.js"}}
                       {:id           "sqs"
                        :source-paths ["src"]
                        :compiler     {:target    :nodejs
                                       :main      cljs-aws.sqs-example
                                       :output-to "target/sqs.js"}}]})
