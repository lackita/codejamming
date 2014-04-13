(defproject codejamming "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]]
  :git-dependencies [["https://github.com/lackita/hiccup-bootstrap.git"]]
  :plugins [[lein-ring "0.8.10"]
            [lein-git-deps "0.0.1-SNAPSHOT"]]
  :ring {:handler codejamming.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [enlive "1.1.5"]]}})
