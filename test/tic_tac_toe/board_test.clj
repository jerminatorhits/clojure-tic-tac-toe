(ns tic-tac-toe.board-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.board :refer :all]))

(deftest board-test
  (testing "creates a fresh board"
    (is (= [1 2 3 4 5 6 7 8 9] (create-board))))

  (testing "checks to see if position is already taken"
    (is (= (empty-space? ["X" 2 3 4 5 6 7 8 9] 1) false)))
  
  (testing "updates board when given a location and mark"
    (is (= ["X" 2 3 4 5 6 7 8 9] (update-board [1 2 3 4 5 6 7 8 9] 1 "X")))))