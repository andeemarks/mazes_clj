(ns mazes-clj.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [mazes-clj.cli :as cli]
            [mazes-clj.grid :as grid])
  (:gen-class))

(defn -main [& args]
  (let [{:keys [action options exit-message ok?]} (cli/validate-args args)]
    (if exit-message
      (cli/exit (if ok? 0 1) exit-message)
      ;; the options at this point will be a map on the format
      ;; {:port 80, :hostname "localhost", :verbosity 0}
      ;; where the values are parsed rich objects if the command line specification
      ;; chooses to use :parse-fn 
      (case action
        "show" (println (grid/to-s (grid/init 3 3)))
        "stop" (println "stopping server with: " options)
        "status" (println "status   server with: " options)))))
