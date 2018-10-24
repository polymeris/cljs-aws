(def aws-sdk-version "2.341.0")

(def browser-aws-sdk-basepath
  (str "https://sdk.amazonaws.com/js/aws-sdk-" aws-sdk-version))

(defproject cljs-aws :lein-v
  :description "Unofficial AWS client for Clojurescript"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [org.clojure/core.async "0.4.474"]
                 [org.clojure/data.json "0.2.6"]
                 [camel-snake-kebab "0.4.0"]]
  :deploy-repositories [["clojars" {:url           "https://clojars.org/repo"
                                    :username      :env/clojars_username
                                    :password      :env/clojars_password
                                    :sign-releases false}]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.10"]
            [com.roomkey/lein-v "6.3.0"]]
  :resource-paths ["node_modules/aws-sdk/apis"]
  :source-paths ["src" "externs" "node_modules/aws-sdk/dist"]
  :aliases {"download-deps" ["cljsbuild" "once" "download-deps"]
            "test-node"     ["doo" "node" "test-node" "once"]
            "test-phantom"  ["doo" "phantom" "test-browser" "once"]}
  :cljsbuild {:builds [{:id           "download-deps"
                        :source-paths ["src"]
                        :compiler     {:install-deps  true
                                       :npm-deps      {:aws-sdk ~aws-sdk-version}
                                       :target        :nodejs
                                       :optimizations :simple}}
                       {:id           "test-node"
                        :source-paths ["src" "test"]
                        :compiler     {:output-to     "target/test-node/test.js"
                                       :output-dir    "target/test-node"
                                       :install-deps  true
                                       :npm-deps      {:aws-sdk ~aws-sdk-version}
                                       :externs       ["aws-sdk.ext.js"]
                                       :target        :nodejs
                                       :main          cljs-aws.test-runner
                                       :optimizations :none}}
                       {:id           "test-browser"
                        :source-paths ["src" "test"]
                        :compiler     {:output-to     "target/test-browser/test.js"
                                       :output-dir    "target/test-browser"
                                       :foreign-libs  [{:file     ~(str browser-aws-sdk-basepath ".js")
                                                        :file-min ~(str browser-aws-sdk-basepath ".min.js")
                                                        :provides ["aws-sdk"]}]
                                       :externs       ["aws-sdk.ext.js"]
                                       :main          cljs-aws.test-runner
                                       :optimizations :none}}]})
