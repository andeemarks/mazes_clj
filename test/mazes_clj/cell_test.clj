(ns mazes-clj.cell-test
  (:require [clojure.test :refer :all]
            [mazes-clj.cell :refer :all]))

(deftest cells
  (testing "have an initially specified position"
    (is (= 2 (:row (:position (init 2 4)))))
    (is (= 4 (:column (:position (init 2 4))))))

  (testing "have an initially empty map of links"
    (is (= '{} (:links (init 2 4)))))

  (testing "can be linked to other cells"
    (let [c (init 2 4)
          c2 (init 1 4)
          c3 (init 3 4)
          links (:links (link (link c c2) c3))]
      (is (= true (get links (:position c2))))
      (is (= true (get links (:position c3))))))

  (testing "can be unlinked from selected cells"
    (let [c (init 2 4)
          c2 (init 1 4)
          c3 (init 3 4)
          c4 (link (link c c2) c3)
          c5 (unlink c4 c2)
          links (:links c5)]
      (is (= nil (get links (:position c2))))
      (is (= true (get links (:position c3))))))

  (testing "know if they're linked to other cells"
    (let [c (init 2 4)
          c2 (init 3 5)
          c3 (link c c2)]
      (is (= false (linked? c c)))
      (is (= true (linked? c3 c2))))))
