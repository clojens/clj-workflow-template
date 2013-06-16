(ns niubi.utils
  (:require [datomic.api :as d]))

(defn make-visit
  "returns a list in datomic format of a dummy visit"
  [campaign-id offer-id lp-id meta-id]
  [ {:db/id #db/id[:db.part/user]
     :visit/start (java.util.Date.)
     :visit/end (java.util.Date.)
     :visit/duration 10
     :visit/campaign campaign-id
     :visit/offer offer-id
     :visit/cost 0.13
     :visit/payout 1.10
     :visit/cthru true
     :visit/converted true
     :visit/lp lp-id
     :visit/keyword "amourcougar"
     :visit/meta [meta-id] }])

(defn flat
  "return all elements in a flat list"
  [query-res]
  (flatten (vec query-res)))

(defn make-n-visits
  "makes n visits. uses the passed function to do any db work
  params is a map of {:camps :lps :offers :metas}, where each value is a list of ids"
  [n params update-fxn]
  (for [i (range n)] (update-fxn
                      (make-visit
                       (first (:camps params))
                       (first (:offers params))
                       (first (:lps params))
                       (first (:metas params))))))

;;Example usage of make-visits
;(def test (u/make-n-visits 3000
 ;                (first camps) (first offers)
  ;               (first lps) (first metas)
;              (partial d/transact conn)