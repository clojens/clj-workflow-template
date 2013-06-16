(ns niubi.routes
  (:require [compojure.core :as cmpj]
            [compojure.route :as route]))

(cmpj/defroutes app
  (cmpj/GET "/" [] "hello tim")
  (route/not-found "<h1>Page not found</h1>"))