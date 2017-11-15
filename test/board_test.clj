(ns board-test
  (:require [clojure.test :refer :all]
            [board :refer :all]))

(deftest board
  (testing "creates an empty board"
    (is (= (create-board) [1 2 3 4 5 6 7 8 9]))))