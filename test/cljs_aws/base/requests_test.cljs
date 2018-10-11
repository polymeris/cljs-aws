(ns cljs-aws.base.requests-test
  (:require [clojure.test :refer [deftest is async]]
            [cljs.core.async :as a]
            [cljs-aws.base.requests :as requests]))

(def test-service-name "test-service")
(def test-operation-name "test-operation")
(def test-params {:test-param-1 :foo})

(defn successful-mock-perform-request!
  [_ operation-name js-params callback]
  (callback nil (clj->js [:success operation-name js-params])))

(defn error-mock-perform-request!
  [_ operation-name _ callback]
  (callback (str "error in " operation-name) nil))

(deftest valid-successful--request--ok
  (async done
    (a/go (with-redefs
            [requests/perform-request! successful-mock-perform-request!]
            (is (= ["success" "test-operation" {:test-param-1 "foo"}]
                   (a/<! (requests/request test-service-name test-operation-name test-params))))
            (done)))))

(deftest valid-error--request--error
  (async done
    (a/go (with-redefs
            [requests/perform-request! error-mock-perform-request!]
            (is (= {:error "error in test-operation"}
                   (a/<! (requests/request test-service-name test-operation-name test-params))))
            (done)))))
