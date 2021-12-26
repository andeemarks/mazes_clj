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

(defn cell-to-s [cell]
  (let [east-of-cell (:east cell)
        east-boundary (if (cell/linked? cell east-of-cell) " " "|")
        south-of-cell (:south cell)
        south-boundary (if (cell/linked? cell south-of-cell) "   " "---")
        top (apply str (concat "|" "   " east-boundary))
        bottom (apply str (concat "+" south-boundary "+"))
        ;; _ (println top "\n")
        ;; _ (println bottom "\n")
        ]
    {:top top
     :bottom bottom}))

(defn row-to-s [row]
  (let [top (map #(apply str (concat (:top (cell-to-s %)))) row)
        bottom (map #(apply str (concat (:bottom (cell-to-s %)))) row)]
    (apply str (concat top "\n" bottom "\n"))))

(defn to-s [grid]
  (let [output (concat "+"
                       (repeat (:columns grid) "---+")
                       "\n"
                       (map #(row-to-s %) (:cells grid)))]
    (apply str output)))