(defproject mazes-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.cli "0.4.1"]]
  :main mazes-clj.core
  :aot [mazes-clj.core]
  :bin {:name "mazes-clj"
        :custom-preamble-script "boot/jar-preamble.sh"}
  :plugins [[lein-binplus "0.6.5"]])
