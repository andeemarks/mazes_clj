(ns mazes-clj.distances
  (:require [mazes-clj.cell :as cell])
  (:gen-class))

(defn init [root]
  {:root root :cells {root 0}})

(defn add [d new-cell distance]
  {:root (:root d) :cells (assoc (:cells d) new-cell distance)})

(defn max [d]
  (let [max-cell (first (apply max-key #(val %) (:cells d)))]
    {:cell max-cell :distance (get (:cells d) max-cell)}))
