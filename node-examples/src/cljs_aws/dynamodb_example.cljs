(ns cljs-aws.dynamodb-example
  (:require [cljs-aws.dynamodb :as db]
            [cljs.core.async :refer [go <! timeout]]
            [cljs-aws.examples-util :as util :refer [throw-or-print]]))


(enable-console-print!)

(def table-name "TestTable")

(defn -main
  "Example cljs script using cljs-aws.
   Create a DynamoDB table, describe it, put an item, get the item and delete the table.
   Set your credentials before executing."
  [& args]
  (go
    (util/override-endpoint-with-env)
    (throw-or-print (<! (db/create-table {:table-name              table-name
                                          :key-schema              [{:attribute-name "id" :key-type "HASH"}
                                                                    {:attribute-name "date" :key-type "RANGE"}]
                                          :attribute-definitions   [{:attribute-name "id" :attribute-type "S"}
                                                                    {:attribute-name "date" :attribute-type "N"}
                                                                    {:attribute-name "column1" :attribute-type "S"}]
                                          :local-secondary-indexes [{:index-name "column1_idx"
                                                                     :key-schema [{:attribute-name "id" :key-type "HASH"}
                                                                                  {:attribute-name "column1" :key-type "RANGE"}]
                                                                     :projection {:projection-type    "INCLUDE"
                                                                                  :non-key-attributes ["id" "date" "column1"]}}]
                                          :provisioned-throughput  {:read-capacity-units 1, :write-capacity-units 1}})))
    (println "Waiting for table to be created...")
    (loop []
      (<! (timeout 5000))
      (let [table-status (-> (<! (db/describe-table {:table-name table-name}))
                             :table
                             :table-status)]
        (println "Table is" table-status)
        (when (= table-status "CREATING") (recur))))
    (throw-or-print (<! (db/put-item {:table-name                     table-name
                                      :return-consumed-capacity       "TOTAL"
                                      :return-item-collection-metrics "SIZE"
                                      :item                           {"id"          {"S" "foo"}
                                                                       "date"        {"N" "123456"}
                                                                       "text"        {"S" "bar"}
                                                                       "column1"     {"S" "baz"}
                                                                       "numbers_set" {"NS" #{"1" "2" "3"}}
                                                                       "string_set"  {"SS" #{"foo" "bar"}}}})))
    (throw-or-print (<! (db/get-item {:table-name table-name
                                      :key        {"id" {:s "foo"}, "date" {:n "123456"}}})))
    (throw-or-print (<! (db/delete-table {:table-name table-name})))))

(set! *main-cli-fn* -main)