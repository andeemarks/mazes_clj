(ns mazes-clj.grid-test
  (:require [clojure.test :refer :all]
            [mazes-clj.grid :refer :all]
            [mazes-clj.cell :as cell]))

(deftest grids

  (testing "are initialised with a size"
    (let [g (init 4 5)]
      (is (= 4 (:rows g)))
      (is (= 5 (:columns g)))))

  (testing "are initiaised with cells"
    (let [g (init 1 2)
          c (:cells g)
          row1 (first c)]
      (is (not-empty c))
      (is (= (cell/init 0 0) (nth row1 0)))
      (is (= (cell/init 0 1) (nth row1 1))))))