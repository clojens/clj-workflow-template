[
 ;; Traffic Sources
 {:db/id #db/id[:db.part/db]
  :db/ident :source/name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Name of traffic source"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :source/id
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Source's id, similar to a user id in a normal app"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :source/tshiddentoken
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "TS Hidden Token"
  :db.install/_attribute :db.part/db }

;TODO - support timezones
 {:db/id #db/id[:db.part/db]
  :db/ident :source/timezone
  :db/valueType :db.type/instant
  :db/cardinality :db.cardinality/one
  :db/doc "Timezone - HOW IS IT HANDLED???"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :source/tokens
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/many
  :db/doc "All the tokens a source uses (keyword will always be there)"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :source/bidtype
  :db/valueType :db.type/keyword
  :db/cardinality :db.cardinality/one
  :db/doc "Can be 'cpv' or 'cpc' for now"
  :db.install/_attribute :db.part/db }

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

 ;; Groups
 {:db/id #db/id[:db.part/db]
  :db/ident :group/name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "name of a group"
  :db.install/_attribute :db.part/db }

;;Campaigns
 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "name of campaign"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/group
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/one
  :db/doc "the group (if any) this campaign is a member of"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/alertprofile
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/one
  :db/doc "what kind of alerts to send"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/optprofile
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/one
  :db/doc "the optimization profile of the campaign"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/source
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/one
  :db/doc "campaign's source - can pre-existing, or custom-generated"
  :db.install/_attribute :db.part/db }
;TODO - handle hidden tokens

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/engagerate
  :db/valueType :db.type/long
  :db/cardinality :db.cardinality/one
  :db/doc "how many milliseconds a user needs to spend on LP to count as engaged"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/cost
  :db/valueType :db.type/double
  :db/cardinality :db.cardinality/one
  :db/doc "cost per click or view - used at creation time of tracking stamps"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/failpage
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "page to go to if things fuck up"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/redirect
  :db/valueType :db.type/keyword
  :db/cardinality :db.cardinality/many
  :db/doc "direct, doublemeta, loop"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/priority
  :db/valueType :db.type/long
  :db/cardinality :db.cardinality/one
  :db/doc "whether this campaign's cookies override those of others. 1 is lowest."
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :campaign/paths
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/many
  :db/doc "each campaign creates and stores one or more paths, which can be direct, LPs, paths, etc"
  :db.install/_attribute :db.part/db }

;;Paths - these are collections of landing page and offer rotations
;;a campaign can have many paths, default is 1
;;a path can have more than 1 offer rotation - these are called "options"
 {:db/id #db/id[:db.part/db]
  :db/ident :path/lps
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/many
  :db/doc "each path has many landing pages"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :path/share
  :db/valueType :db.type/long
  :db/cardinality :db.cardinality/one
  :db/doc "percentage path gets rotated with, default is 100% for 1 path"
  :db.install/_attribute :db.part/db }
;;TODO - make a fxn to enforce Path percents adding up to 100
 {:db/id #db/id[:db.part/db]
  :db/ident :path/options
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/many
  :db/doc "An option is a collection of offers, default is to have just 1"
  :db.install/_attribute :db.part/db }

;;Options
 {:db/id #db/id[:db.part/db]
  :db/ident :option/offers
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/many
  :db/doc "Offers in this Option set (used when you have more than 1 link on an LP"
  :db.install/_attribute :db.part/db }

;;Landing Page
;;TODO - make a transactor fxn to enforce LP percents adding up to 100 and to update all at once
 {:db/id #db/id[:db.part/db]
  :db/ident :lp/share
  :db/valueType :db.type/long
  :db/cardinality :db.cardinality/one
  :db/doc "frequency this page gets rotated with, out of 100%"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :lp/name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Name of the Landing Page, for display purposes"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :lp/uri
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "URI where the Landing Page is located"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :lp/active
  :db/valueType :db.type/boolean
  :db/cardinality :db.cardinality/one
  :db/doc "Whether the LP is turned on"
  :db.install/_attribute :db.part/db }

;;Offer
 {:db/id #db/id[:db.part/db]
  :db/ident :offer/uri
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "URI where the Offer is located"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :offer/name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Offer's name"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :offer/active
  :db/valueType :db.type/boolean
  :db/cardinality :db.cardinality/one
  :db/doc "Whether the offer is 'turned on'"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :offer/share
  :db/valueType :db.type/long
  :db/cardinality :db.cardinality/one
  :db/doc "frequency this offer gets rotated with, out of 100%"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :offer/payout
  :db/valueType :db.type/double
  :db/cardinality :db.cardinality/one
  :db/doc "amount the offer pays"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :offer/network
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/one
  :db/doc "the network that this offer is from"
  :db.install/_attribute :db.part/db }

;;Visit - all data associated with one visitor
 {:db/id #db/id[:db.part/db]
  :db/ident :visit/start
  :db/valueType :db.type/instant
  :db/cardinality :db.cardinality/one
  :db/doc "The time of the visit, adjusted to GMT"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/end
  :db/valueType :db.type/instant
  :db/cardinality :db.cardinality/one
  :db/doc "The time the visit ended, adjusted to GMT"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/duration
  :db/valueType :db.type/long
  :db/cardinality :db.cardinality/one
  :db/doc "Number of milliseconds the visit lasted. Note: if this field is not populated, it can be auto-calculated from the above"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/campaign
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/one
  :db/doc "Campaign of this visitor"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/cost
  :db/valueType :db.type/double
  :db/cardinality :db.cardinality/one
  :db/doc "Cost to acquire this visitor"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/payout
  :db/valueType :db.type/double
  :db/cardinality :db.cardinality/one
  :db/doc "How much this visit paid on conversion"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/cthru
  :db/valueType :db.type/boolean
  :db/cardinality :db.cardinality/one
  :db/doc "Whether the user clicked thru (auto true for direct-linking)"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/converted
  :db/valueType :db.type/boolean
  :db/cardinality :db.cardinality/one
  :db/doc "Whether the user converted"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/lp
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/one
  :db/doc "the LP the user landed on"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/offer
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/one
  :db/doc "the Offer the user was sent to, if any"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/keyword
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "the keyword that the user arrived via, if any"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :visit/meta
  :db/valueType :db.type/ref
  :db/cardinality :db.cardinality/many
  :db/doc "A list of all parameters we want to record about this visit"
  :db.install/_attribute :db.part/db }

;;Meta - all meta-data of parameters about a visit: IP, Country, etc
 {:db/id #db/id[:db.part/db]
  :db/ident :meta/name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Parameter name (e.g. 'Country')"
  :db.install/_attribute :db.part/db }

 {:db/id #db/id[:db.part/db]
  :db/ident :meta/value
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Parameter value (e.g. 'USA')"
  :db.install/_attribute :db.part/db }

]