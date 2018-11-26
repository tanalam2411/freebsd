(use '[datomic.api :only [q db] :as d])
(use 'clojure.pprint)


(def uri "datomic:free://localhost:4334/testdb")

(d/create-database uri)

(def conn (d/connect uri))

(def schema-tx (read-string (slurp "/root/performance/datomic/datomic-free-0.9.5703/code/testtable-schema.edn")))

(first schema-tx)

@(d/transact conn schema-tx)

(def data-tx (read-string (slurp "/root/performance/datomic/datomic-free-0.9.5703/code/testtable-data0.edn")))

@(d/transact conn data-tx)

