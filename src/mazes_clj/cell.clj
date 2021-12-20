(ns mazes-clj.cell
  (:gen-class))

(defn init [row column] {:row row :column column :links '{}})

(defn link [cell other]
  {:row (:row cell)
   :column (:column cell)
   :links (assoc (:links cell)
                 {:row (:row other) :column (:column other)}
                 true)})

(defn linked? [cell other]
  (contains? (:links cell) {:row (:row other) :column (:column other)}))