;;Everything needed to get and set campaign information
(ns niubi.campaign
  (:require [datomic.api :as d]
            [niubi.db :as db]
            [niubi.utils :as u]))

(defn camp-spend
  [conn camp-id]
  (first (u/flat (d/q '[:find (sum ?cost) :with ?visit :in $ ?cid :where
                        [?visit :visit/campaign ?cid]
                        [?visit :visit/cost ?cost]]
                      (d/db conn)
                      camp-id))))

(defn camp-rev
  "returns gross amount earned by the campaign"
  [conn camp-id]
  (first (u/flat (d/q '[:find (sum ?payout) :with ?visit :in $ ?cid :where
                        [?visit :visit/campaign ?cid]
                        [?visit :visit/payout ?payout]
                        [?visit :visit/converted true]]
                      (d/db conn)
                      camp-id))))

(defn camp-profit
  [conn camp-id]
  (- (camp-rev conn camp-id)
     (camp-spend conn camp-id)))