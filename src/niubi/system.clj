;;all functions required to bootstrap the system environment
(ns niubi.system
  (:require [datomic.api :as d]
            [niubi.db :as db]
            [niubi.utils :as u]
            [niubi.routes :as r]
            [ring.util.serve :as ringserve]))

(defn get-dbvals
  "Returns a map of:
  {:camps camp_ids :lps lp_ids :offers offer_ids :meta meta_ids}"
  [conn]
  {:camps (db/get-all conn :campaign/name)
   :lps (db/get-all conn :lp/name)
   :offers (db/get-all conn :offer/name)
   :metas (db/get-all conn :meta/name)})

(defn db-reset
  "Used only for the in-memory database NOT for disk one."
  [uri]
   (d/delete-database uri)
   (d/create-database uri)
   (d/connect uri))

(defn db-scaffold
  "set up schema and basic values for in-memory database"
  [conn schema data]
  (db/file-transact conn schema)
  (db/file-transact conn data))

;---------------SYSTEM FXNS-------------------
(defn system-dev
  "Returns a new instance of the whole application"
  []
  {:db {:uri "datomic:mem://dev"
        :schema "/Users/timati/projects/niubi/resources/schema.clj"
        :data "/Users/timati/projects/niubi/resources/data.clj"}
   :handler r/app
   :server {:port 8080}})

(defn start
  "Performs side effects to initialize the system, acquire resources,
  and start it running. Returns an updated instance of the system."
  [system]
  (let [dbmap (:db system)
        conn (db-reset (:uri dbmap))]
    (db-scaffold conn (:schema dbmap) (:data dbmap))
    (ringserve/serve-headless (:handler system))
    (-> system
        (assoc-in [:db :conn] conn)
        (assoc-in [:db :vals] (get-dbvals conn)))))

(defn stop
  "Performs side effects to shut down the system and release its
  resources. Returns an updated instance of the system."
  [system]
  (ringserve/stop-server)
  (when (:conn (:db system))
    (d/release (:conn (:db system))))
  system
)
