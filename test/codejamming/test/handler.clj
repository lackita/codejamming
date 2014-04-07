(ns codejamming.test.handler
  (:use clojure.test
        ring.mock.request  
        codejamming.handler
        crouton.html))

(defn- stream [s]
  (java.io.ByteArrayInputStream. (.getBytes s)))

(defn parse-string [s]
  (parse (stream s)))

(defn get-user-login-page []
  (app (request :get "/login/")))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))
  
  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

(deftest test-user-login-page
  ;; (pending "user logs in"
  ;;   (get-user-login-page))
  (testing "page contents"
    (is (= (:status (get-user-login-page)) 200))))
