[
 ;; Tokens
 {:db/id #db/id[:db.part/db]
  :db/ident :token/name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Like 'Keyword' or 'Category'"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :token/urlappend
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "The string appended to a url, like '&keyword={KEYWORD}'"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :token/parameter
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "the name of a parameter, e.g. 'keyword' or 'age'"
  :db.install/_attribute :db.part/db }
]
