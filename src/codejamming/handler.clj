(ns codejamming.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.page :refer [html5]]))

(defroutes app-routes
  (GET "/" [] (html5 [:nav {:class "navbar navbar-default navbar-static-top"
                            :role "navigation"}]))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
