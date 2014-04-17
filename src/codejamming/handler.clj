(ns codejamming.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.page :refer [html5]]
            [hiccup.bootstrap.page :refer [include-bootstrap]]
            [hiccup.bootstrap.components :refer [navbar]]
            [hiccup.bootstrap.middleware :refer [wrap-bootstrap-resources]]))

(defroutes app-routes
  (GET "/" [] (html5 [:head
                      [:title "Rock Your Code Out"]
                      (include-bootstrap)]
                     [:body (navbar {:header "Code Jamming"})]))
  (route/resources "/")
  (route/resources "/bootstrap" (:root "bootstrap/public"))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
