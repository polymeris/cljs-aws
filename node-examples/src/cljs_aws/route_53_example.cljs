(ns cljs-aws.route-53-example
  (:require [cljs-aws.route-53 :as route-53]
            [cljs.core.async :refer [go <!]]
            [cljs-aws.examples-util :as util :refer [throw-or-print]]))

(enable-console-print!)

(defn -main
  "Example cljs script using cljs-aws."
  [& args]
  (go
    (util/override-endpoint-with-env)
    (let [health-check-id (-> (<! (route-53/create-health-check
                                    {:caller-reference    (str (random-uuid))
                                     :health-check-config {:port                        80
                                                           :type                        "HTTP"
                                                           "IPAddress"                  "127.0.0.1"
                                                           :fully-qualified-domain-name "example.com"}}))
                              (throw-or-print)
                              :health-check
                              :id)
          hosted-zone-id (-> (<! (route-53/create-hosted-zone {:name             "example.com"
                                                               :caller-reference (str (random-uuid))}))
                             (throw-or-print)
                             :hosted-zone
                             :id)]
      (throw-or-print (<! (route-53/list-health-checks)))
      (throw-or-print (<! (route-53/list-hosted-zones)))
      (println (<! (route-53/delete-health-check {:health-check-id health-check-id})))
      (println (<! (route-53/delete-hosted-zone {:id hosted-zone-id}))))))

(set! *main-cli-fn* -main)
