(defproject zahlenschloss "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "GNU General Public License Version 3"
            :url "https://www.gnu.org/licenses/gpl-3.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot zahlenschloss.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
