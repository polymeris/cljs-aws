(defn cljsbuild-example [example-name]
  {:id           example-name
   :source-paths ["src"]
   :compiler     {:main          (symbol (str "cljs-aws." example-name "-example"))
                  :output-to     (str "target/" example-name ".js")
                  :target        :nodejs
                  :optimizations :advanced}})

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
  :cljsbuild {:builds ~(map cljsbuild-example
                         ["cloudwatch"
                          "dynamodb"
                          "kinesis"
                          "route-53"
                          "s3"
                          "sns"
                          "sqs"])})
