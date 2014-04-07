(ns codejamming.test.handler
  (:use clojure.test
        ring.mock.request  
        codejamming.handler
        crouton.html))

(defn status-is [r c]
  (is (= (:status r) c)))

(defn get-page [p]
  (app (request :get p)))

(deftest root-test
  (status-is (get-page "/") 200))

(deftest invalid-test
  (status-is (get-page "/invalid") 404))

(deftest test-user-login-page
  (status-is (get-page "/login/") 200)
  (is (re-find #"<html>.*</html>" (:body (get-page "/login/")))))
