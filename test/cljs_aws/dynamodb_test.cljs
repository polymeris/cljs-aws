(ns cljs-aws.dynamodb-test
  (:require [clojure.test :refer [deftest is async]]
            [camel-snake-kebab.core :refer [->camelCaseString]]
            [cljs.core.async :as a]
            [cljs-aws.dynamodb :as dynamodb])
  (:require-macros [cljs-aws.test-macros :refer [with-example-mocks]]))

(deftest examples--dynamodb--ok
  (async done
    (a/go
      (with-example-mocks "DynamoDB" "dynamodb-2012-08-10.examples.json"
        (is (= {:table-description {:attribute-definitions  [{:attribute-name "Artist", :attribute-type "S"}
                                                             {:attribute-name "SongTitle", :attribute-type "S"}]
                                    :creation-date-time     "1421866952.062"
                                    :item-count             0
                                    :key-schema             [{:attribute-name "Artist", :key-type "HASH"}
                                                             {:attribute-name "SongTitle", :key-type "RANGE"}]
                                    :provisioned-throughput {:read-capacity-units 5, :write-capacity-units 5}
                                    :table-name             "Music"
                                    :table-size-bytes       0
                                    :table-status           "CREATING"}}
               (a/<! (dynamodb/create-table {:attribute-definitions  [{:attribute-name "Artist", :attribute-type "S"}
                                                                      {:attribute-name "SongTitle", :attribute-type "S"}]
                                             :key-schema             [{:attribute-name "Artist", :key-type "HASH"}
                                                                      {:attribute-name "SongTitle", :key-type "RANGE"}]
                                             :provisioned-throughput {:read-capacity-units  5
                                                                      :write-capacity-units 5}
                                             :table-name             "Music"}))))
        (is (= {:consumed-capacity {:capacity-units 1, :table-name "Music"}}
               (a/<! (dynamodb/delete-item {:key        {:artist     {:s "No One You Know"}
                                                         :song-title {:s "Scared of My Shadow"}}
                                            :table-name "Music"}))))
        (is (= {:table-description
                {:item-count             0
                 :provisioned-throughput {:number-of-decreases-today 1
                                          :read-capacity-units       5
                                          :write-capacity-units      5}
                 :table-name             "Music"
                 :table-size-bytes       0
                 :table-status           "DELETING"}}
               (a/<! (dynamodb/delete-table {:table-name "Music"}))))
        (is (= {:table
                {:attribute-definitions  [{:attribute-name "Artist", :attribute-type "S"}
                                          {:attribute-name "SongTitle", :attribute-type "S"}]
                 :creation-date-time     "1421866952.062"
                 :item-count             0
                 :key-schema             [{:attribute-name "Artist", :key-type "HASH"}
                                          {:attribute-name "SongTitle", :key-type "RANGE"}]
                 :provisioned-throughput {:number-of-decreases-today 1
                                          :read-capacity-units       5
                                          :write-capacity-units      5}
                 :table-name             "Music"
                 :table-size-bytes       0
                 :table-status           "ACTIVE"}}
               (a/<! (dynamodb/describe-table {:table-name "Music"}))))
        (is (= {:account-max-read-capacity-units  20000
                :account-max-write-capacity-units 20000
                :table-max-read-capacity-units    10000
                :table-max-write-capacity-units   10000}
               (a/<! (dynamodb/describe-limits {}))))
        (is (= {:item
                {:album-title {:s "Songs About Life"}
                 :artist      {:s "Acme Band"}
                 :song-title  {:s "Happy Day"}}}
               (a/<! (dynamodb/get-item {:key        {"Artist"    {:s "Acme Band"}
                                                      "SongTitle" {:s "Happy Day"}}
                                         :table-name "Music"}))))
        (is (= {:table-names ["Forum" "ProductCatalog" "Reply" "Thread"]}
               (a/<! (dynamodb/list-tables {}))))
        (is (= {:consumed-capacity {:capacity-units 1, :table-name "Music"}}
               (a/<! (dynamodb/put-item {:item                     {"AlbumTitle" {:s "Somewhat Famous"}
                                                                    "Artist"     {:s "No One You Know"}
                                                                    "SongTitle"  {:s "Call Me Today"}}
                                         :return-consumed-capacity "TOTAL"
                                         :table-name               "Music"}))))
        (is (= {:consumed-capacity {}
                :count             2
                :items             [{:song-title {:s "Call Me Today"}}]
                :scanned-count     2}
               (a/<! (dynamodb/query {:expression-attribute-values {":v1" {:s "No One You Know"}}
                                      :key-condition-expression    "Artist = :v1"
                                      :projection-expression       "SongTitle"
                                      :table-name                  "Music"}))))
        (is (= {:consumed-capacity {}
                :count             2
                :items             [{:album-title {:s "Somewhat Famous"}, :song-title {:s "Call Me Today"}}
                                    {:album-title {:s "Blue Sky Blues"}, :song-title {:s "Scared of My Shadow"}}]
                :scanned-count     3}
               (a/<! (dynamodb/scan {:expression-attribute-names  {"AT" "AlbumTitle"
                                                                   "ST" "SongTitle"}
                                     :expression-attribute-values {":a" {:s "No One You Know"}}
                                     :filter-expression           "Artist = :a"
                                     :projection-expression       "#ST, #AT"
                                     :table-name                  "Music"}))))
        (is (= {:attributes {:album-title {:s "Louder Than Ever"}
                             :artist      {:s "Acme Band"}
                             :song-title  {:s "Happy Day"}
                             :year        {:n "2015"}}}
               (a/<! (dynamodb/update-item {:expression-attribute-names  {"#AT" "AlbumTitle"
                                                                          "#Y"  "Year"}
                                            :expression-attribute-values {":t" {:s "Louder Than Ever"}
                                                                          ":y" {:n "2015"}}
                                            :key                         {"Artist"    {:s "Acme Band"}
                                                                          "SongTitle" {:s "Happy Day"}}
                                            :return-values               "ALL_NEW"
                                            :table-name                  "Music"
                                            :update-expression           "SET #Y = :y, #AT = :t"}))))
        (is (= {:table-description {:attribute-definitions  [{:attribute-name "Artist", :attribute-type "S"}
                                                             {:attribute-name "SongTitle", :attribute-type "S"}]
                                    :creation-date-time     "1421866952.062"
                                    :item-count             0
                                    :key-schema             [{:attribute-name "Artist", :key-type "HASH"}
                                                             {:attribute-name "SongTitle", :key-type "RANGE"}]
                                    :provisioned-throughput {:last-increase-date-time   "1421874759.194"
                                                             :number-of-decreases-today 1
                                                             :read-capacity-units       1
                                                             :write-capacity-units      1}
                                    :table-name             "MusicCollection"
                                    :table-size-bytes       0
                                    :table-status           "UPDATING"}}
               (a/<! (dynamodb/update-table {:provisioned-throughput {:read-capacity-units  10
                                                                      :write-capacity-units 10}
                                             :table-name             "MusicCollection"}))))
        (done)))))