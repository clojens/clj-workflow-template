(ns user
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.pprint :refer (pprint)]
            [clojure.repl :refer :all]
            [clojure.test :as test]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]
            [datomic.api :as d]
            [niubi.system :as system]
            [niubi.db :as db]
            [niubi.utils :as u]
            [niubi.campaign :as c]))

(def system nil)

(defn init
  "Initialize system variables, NO side effects"
  []
  (alter-var-root #'system
                  (constantly (system/system-dev))))

(defn start
  "Start the system along with all side-effects"
  []
  (alter-var-root #'system
                  system/start))

(defn stop
  "Releases all resources used"
  []
  (alter-var-root #'system
                  (fn [s] (when s (system/stop s)))))

(defn go
  "Initializes the current development system and starts it running."
  []
  (init)
  (start))

(defn reset []
  (stop)
  (refresh :after 'user/go))