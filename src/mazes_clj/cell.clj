(ns mazes-clj.cell
  (:gen-class))

(defn init [row column] {:position {:row row :column column} :links '{}})

(defn link [cell other]
  {:position (:position cell)
   :links (assoc (:links cell)
                 (:position other)
                 true)})

(defn linked? [cell other]
  (contains? (:links cell) (:position other)))

(defn unlink [cell other]
  {:position (:position cell)
   :links (dissoc (:links cell)
                  (:position other))})
