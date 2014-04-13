(ns codejamming.test.handler
  (:use clojure.test
        ring.mock.request  
        codejamming.handler)
  (:require [net.cgrand.enlive-html :as html]))

(defn status-is [r c]
  (is (= (:status r) c)))

(defn get-page [p]
  (app (request :get p)))

(defn parse-page [p]
  (html/html-snippet (:body (get-page p))))

(deftest root-test
  (status-is (get-page "/") 200)
  (testing "navbar"
    (is (= (:role (:attrs (first (html/select (parse-page "/")
                                              [:nav.navbar.navbar-default.navbar-static-top]))))
           "navigation"))))

(deftest invalid-test
  (status-is (get-page "/invalid") 404))
