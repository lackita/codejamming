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

(defn search-in [page args]
  (first (:content (first (filter (or (args :with) (fn [_] true))
                                  (html/select (parse-page "/") (args :for)))))))

(deftest root-test
  (status-is (get-page "/") 200)
  (testing "head"
    (is (search-in "/" {:for [:head :link]
                        :with #(-> (re-find #"bootstrap"
                                            (:href (:attrs %))))}))
    (is (= (search-in "/" {:for [:head :title]})
           "Rock Your Code Out")))
  (testing "navbar"
    (is (= (search-in "/" {:for [:body :a.navbar-brand]})
           "Code Jamming"))))

(deftest invalid-test
  (status-is (get-page "/invalid") 404))
