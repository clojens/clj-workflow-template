[
 ;;Tokens - prefix 12
 {:db/id #db/id[:db.part/user -1200001] :token/name "Keyword"}
 {:db/id #db/id[:db.part/user -1200001] :token/urlappend "&keyword={KEYWORD}"}
 {:db/id #db/id[:db.part/user -1200001] :token/parameter "keyword"}

 ;; Traffic Sources- prefix 11
 {:db/id #db/id[:db.part/user -1100001] :source/name "Google AdWords"}
 {:db/id #db/id[:db.part/user -1100001] :source/id "adwords"}
 {:db/id #db/id[:db.part/user -1100001] :source/bidtype :source.bidtype/cpv}
 {:db/id #db/id[:db.part/user -1100001]
  :source/tokens [#db/id[:db.part/user -1200001]]}

 ;;Landing Pages - prefix 15
 {:db/id #db/id[:db.part/user -1500001] :lp/share 50}
 {:db/id #db/id[:db.part/user -1500001] :lp/name "French Love"}
 {:db/id #db/id[:db.part/user -1500001] :lp/uri "http://www.upnamic.com/french1.html"}
 {:db/id #db/id[:db.part/user -1500001] :lp/active true}

 {:db/id #db/id[:db.part/user -1500002] :lp/share 50}
 {:db/id #db/id[:db.part/user -1500002] :lp/name "French Amour"}
 {:db/id #db/id[:db.part/user -1500002] :lp/uri "http://www.upnamic.com/french2.html"}
 {:db/id #db/id[:db.part/user -1500002] :lp/active true}

 ;;Options - prefix 16
 {:db/id #db/id[:db.part/user -1600001]
  :option/offers [#db/id[:db.part/user -1700001] #db/id[:db.part/user -1700002]]}
 ;;Offers - prefix 17
 {:db/id #db/id[:db.part/user -1700001] :offer/share 50}
 {:db/id #db/id[:db.part/user -1700001] :offer/name "French Young Chicks"}
 {:db/id #db/id[:db.part/user -1700001] :offer/uri "http://www.network.com/offer1.html"}
 {:db/id #db/id[:db.part/user -1700001] :offer/active true}
 {:db/id #db/id[:db.part/user -1700001] :offer/payout 1.20}

 {:db/id #db/id[:db.part/user -1700002] :offer/share 50}
 {:db/id #db/id[:db.part/user -1700002] :offer/name "French Cougars"}
 {:db/id #db/id[:db.part/user -1700002] :offer/uri "http://www.network.com/offer2.html"}
 {:db/id #db/id[:db.part/user -1700002] :offer/active true}
 {:db/id #db/id[:db.part/user -1700002] :offer/payout 1.55}

 ;;Paths - prefix 14
 {:db/id #db/id[:db.part/user -1400001]
  :path/lps [#db/id[:db.part/user -1500001] #db/id[:db.part/user -1500002]]}
 {:db/id #db/id[:db.part/user -1400001] :path/options [#db/id[:db.part/user -1600001]]}
 {:db/id #db/id[:db.part/user -1400001] :path/share 100}

 ;;Campaign - prefix 13
 {:db/id #db/id[:db.part/user -1300001] :campaign/name "Large Boobs"}
 {:db/id #db/id[:db.part/user -1300001] :campaign/source #db/id[:db.part/user -1100001]}
 {:db/id #db/id[:db.part/user -1300001] :campaign/engagerate 0}
 {:db/id #db/id[:db.part/user -1300001] :campaign/cost 0.11}
 {:db/id #db/id[:db.part/user -1300001] :campaign/failpage "http://www.google.com"}
 {:db/id #db/id[:db.part/user -1300001] :campaign/redirect :campaign.redirect/direct}
 {:db/id #db/id[:db.part/user -1300001] :campaign/priority 1}
 {:db/id #db/id[:db.part/user -1300001] :campaign/paths  [#db/id[:db.part/user -1400001]]}

 ;;Meta Data - prefix 18
  {:db/id #db/id[:db.part/user -1800001] :meta/name "Country"}
  {:db/id #db/id[:db.part/user -1800001] :meta/value "USA"}
  {:db/id #db/id[:db.part/user -1800002] :meta/name "IP"}
  {:db/id #db/id[:db.part/user -1800002] :meta/value "192.168.0.1"}

  ;;Visit - prefix 19
  {:db/id #db/id[:db.part/user -1900001] :visit/start #inst "2012-09-11T11:51:26.002-00:00"}
  {:db/id #db/id[:db.part/user -1900001] :visit/end #inst "2012-09-11T11:51:30.002-00:00"}
  {:db/id #db/id[:db.part/user -1900001] :visit/duration 4000}
  {:db/id #db/id[:db.part/user -1900001] :visit/campaign #db/id[:db.part/user -1300001]}
  {:db/id #db/id[:db.part/user -1900001] :visit/offer #db/id[:db.part/user -1700001]}
  {:db/id #db/id[:db.part/user -1900001] :visit/cost 0.11}
  {:db/id #db/id[:db.part/user -1900001] :visit/payout 1.20}
  {:db/id #db/id[:db.part/user -1900001] :visit/cthru true}
  {:db/id #db/id[:db.part/user -1900001] :visit/converted true}
  {:db/id #db/id[:db.part/user -1900001] :visit/lp #db/id[:db.part/user -1500001]}
  {:db/id #db/id[:db.part/user -1900001] :visit/keyword "amourcougar"}
  {:db/id #db/id[:db.part/user -1900001] :visit/meta
   [#db/id[:db.part/user -1800001] #db/id[:db.part/user -1800002]]}

]