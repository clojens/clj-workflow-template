(ns niubi.db
  (:require  [datomic.api :only [q db] :as d]))

(defn get-vals
  "returns a vector of the value(s) associated with the attritute of a given entity"
  [conn entity-id attribute]
  (vec (d/q '[:find ?value :in $ ?entity ?attr :where
              [?entity ?attr ?value]]
            (d/db conn)
            entity-id
            attribute)))

(defn get-ents
  "returns a vector of the entit(ies) associated with a given attribute and value"
  [conn value attribute]
  (vec (d/q '[:find ?entity :in $ ?value ?attr :where
              [?entity ?attr ?value]]
            (d/db conn)
            value
            attribute)))

(defn get-attrs
  "Simple function to pull out all the attributes of an entity into a map"
  [conn id]
  (let [ db (d/db conn)
         e (d/entity db id)]
    (select-keys e (keys e))))

(defn get-one
  [])

(defn get-all
  [])


;-----------------------------------------------------
;list of all the functions available in the database for users
;DELETED
;-----------------------------------------------------

(defn file-transact [conn filename]
  (d/transact conn (read-string (slurp filename))))

(defn setup-env
 "returns a connection to a database, and a map of fxns on the db {:conn connection :fxns {:f1 f1 :f2 f2...}}
NOTE: this uses the local variable 'fxns' "
  [uri schema-file data-file]
  (let [conn (d/connect uri)]
;    (file-transact conn schema-file)
 ;   (file-transact conn data-file)
      {:conn conn
       :fxns (zipmap (map #(keyword (name (:name (meta %)))) fxns)
                     (map #(partial (deref %) conn) fxns))}))

(defn setup-and-reset
  [uri schema-file data-file]
  (d/delete-database uri)
  (d/create-database uri)
  (setup-env uri schema-file data-file))
;-------------------------------------------;
