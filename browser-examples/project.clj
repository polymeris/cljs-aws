(defproject cljs-aws-browser-examples :lein-v
  :description "Browser examples for cljs-aws"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [org.clojure/core.async "0.4.474"]
                 [prismatic/dommy "1.1.0"]
                 [cljs-aws nil]]
  :plugins [[lein-figwheel "0.5.16"]
            [lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]
            [lein-npm "0.6.2"]
            [com.roomkey/lein-v "6.3.0"]]
  :middleware [leiningen.v/version-from-scm
               leiningen.v/dependency-version-from-scm
               leiningen.v/add-workspace-data]
  :npm {:dependencies [[aws-sdk "2.94.0"]]}
  :clean-targets ^{:protect false} ["resources/public/js/compiled"]
  :cljsbuild {:builds
              [{:id           "lambda"
                :source-paths ["src"]
                :figwheel     {:open-urls ["http://localhost:3449/lambda.html"]}
                :compiler     {:main       cljs-aws.lambda-example
                               :asset-path "js/compiled/out"
                               :output-to  "resources/public/js/compiled/out/lambda-example.js"
                               :output-dir "resources/public/js/compiled/out"}}]})
