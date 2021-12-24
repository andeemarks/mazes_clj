(ns mazes-clj.grid-test
  (:require [clojure.test :refer :all]
            [mazes-clj.grid :refer :all]))

(deftest grids

  (testing "are initialised with a size"
    (let [g (init 4 5)]
      (is (= 4 (:rows g)))
      (is (= 5 (:columns g)))))

  (testing "can calculate relative distances"))