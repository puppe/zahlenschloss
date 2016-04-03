(defproject zahlenschloss "1.0.0"
  :description "Lösung für die Logelei aus ZEITmagazin 14/2016"
  :url "https://github.com/puppe/zahlenschloss"
  :license {:name "GNU General Public License Version 3"
            :url "https://www.gnu.org/licenses/gpl-3.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot zahlenschloss.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
