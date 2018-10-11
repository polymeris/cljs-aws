(ns cljs-aws.examples-util
  (:require [cljs-aws.base.config :as config]))

(defn override-endpoint-with-env []
  (when-let [env (aget js/process.env "AWS_ENDPOINT")]
    (println "Using endpoint" env)
    (config/set-endpoint! env)))

(defn throw-or-print [{:keys [error] :as data}]
  (if error (throw (ex-info error nil))
            (println data))
  data)