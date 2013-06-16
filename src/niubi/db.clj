(ns niubi.db
  (:require  [datomic.api :only [q db] :as d]
             [niubi.utils :as u]))

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
  "returns a flat list of all entity ids that have a certain attribute.
  Great for finding all campaigns etc"
  [conn attribute]
  (u/flat
   (d/q '[:find ?ent :in $ ?attr :where
          [?ent ?attr _]]
        (d/db conn)
        attribute)))


;-----------------------------------------------------

(defn file-transact [conn filename]
  (d/transact conn (read-string (slurp filename))))
