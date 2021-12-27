(ns mazes-clj.distances-test
  (:require [clojure.test :refer :all]
            [mazes-clj.distances :as d]
            [mazes-clj.cell :as cell]))

(deftest distances
  (testing "are initialised with only a root"
    (let [c (cell/init 1 1)]
      (is (= {:root c :cells {c 0}} (d/init c)))))

  (testing "can persist distances to additional cells"
    (let [d (d/init (cell/init 1 1))
          c (cell/init 2 2)
          d2 (d/add d c 3)]
      (is (= 3 (get (:cells d2) c)))))

  (testing "can find a path to a goal")

  (testing "can find the maximum distance to any cell"
    (let [d (-> (d/init (cell/init 0 0))
                (d/add (cell/init 0 1) 2)
                (d/add (cell/init 1 0) 3)
                (d/add (cell/init 1 1) 1))
          max-distance (d/max d)]
      (is (= 3 (:distance max-distance)))
      (is (= (cell/init 1 0) (:cell max-distance))))))