(ns mazes-clj.grid
  (:require [mazes-clj.cell :as cell])
  (:gen-class))

(defn init-cells [rows columns]
  (for [r (range rows)]
    (map (fn [c] (cell/init r c)) (range columns))))

(defn init [rows columns]
  {:rows rows :columns columns :cells (init-cells rows columns)})
