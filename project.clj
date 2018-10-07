(defproject cljs-aws "0.1.0-SNAPSHOT"
  :description "Unofficial AWS client for Clojurescript"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [org.clojure/core.async "0.4.474"]
                 [org.clojure/data.json "0.2.6"]
                 [camel-snake-kebab "0.4.0"]
                 [cljsjs/aws-sdk-js "2.94.0-0"]]            ; for the externs
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-npm "0.6.2"]
            [lein-doo "0.1.10"]]
  :npm {:dependencies [[aws-sdk "2.94.0"]]}
  :cljsbuild {:builds [{:id           "test"
                        :source-paths ["src" "test"]
                        :compiler     {:output-to     "target/test/test.js"
                                       :output-dir    "target/test"
                                       :target        :nodejs
                                       :main          cljs-aws.test-runner
                                       :optimizations :none}}
                       {:id           "example"
                        :source-paths ["examples" "src"]
                        :compiler     {:output-to     "target/example/example.js"
                                       :output-dir    "target/example"
                                       :target        :nodejs
                                       :main          cljs-aws.s3-example
                                       :optimizations :advanced}}]}
  :doo {:build "test", :alias {:default [:node]}})
