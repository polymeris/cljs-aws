(def aws-sdk-version "2.94.0")

(defn cljsbuild-example [example-name]
  {:id           "lambda"
   :source-paths ["src"]
   :figwheel     {:open-urls ["http://localhost:3449/" example-name ".html"]}
   :compiler     {:main         (symbol (str "cljs-aws." example-name "-example"))
                  :asset-path   "js/compiled/out"
                  :output-to    (str "resources/public/js/compiled/out/" example-name "-example.js")
                  :output-dir   "resources/public/js/compiled/out"
                  :foreign-libs [{:file     (str "https://sdk.amazonaws.com/js/aws-sdk-" aws-sdk-version ".js")
                                  :provides ["aws-sdk"]}]}})

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
            [com.roomkey/lein-v "6.3.0"]]
  :middleware [leiningen.v/version-from-scm
               leiningen.v/dependency-version-from-scm
               leiningen.v/add-workspace-data]
  :clean-targets ^{:protect false} ["resources/public/js/compiled"]
  :cljsbuild {:builds ~(map cljsbuild-example
                         ["lambda"])})
