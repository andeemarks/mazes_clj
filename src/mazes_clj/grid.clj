(ns mazes-clj.grid
  (:require [mazes-clj.cell :as cell])
  (:gen-class))

(defn configure-cell [row column]
  (-> (cell/init row column)
      (assoc :north (cell/init (dec row) column))
      (assoc :south (cell/init (inc row) column))
      (assoc :west (cell/init row (dec column)))
      (assoc :east (cell/init row (inc column)))))

(defn prepare-grid [rows columns]
  (for [r (range rows)]
    (map (fn [c] (configure-cell r c)) (range columns))))

(defn init [rows columns]
  {:rows rows :columns columns :cells (prepare-grid rows columns)})

(defn size [cell]
  (* (:rows cell) (:columns cell)))