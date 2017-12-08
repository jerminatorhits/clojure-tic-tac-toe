(ns tic-tac-toe.rules-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.rules :refer :all]))

(deftest rules-test
  (testing "returns true if given 3 in a row horizontally"
    (is (= (horizontal-win ["X" "X" "X" 4 5 6 7 8 9]) true)))

  (testing "returns false if given no horizontal win"
    (is (= (horizontal-win [1 "X" "X" "X" 5 6 7 8 9]) false)))
  
  (testing "returns true if given 3 in a row vertically"
    (is (= (vertical-win ["X" 2 3 "X" 5 6 "X" 8 9]) true)))
  
  (testing "returns false if given no vertical win"
    (is (= (vertical-win [1 "X" 3 "X" 5 6 "X" 8 9]) false)))
  
  (testing "returns true if diagonal win exists"
    (is (= (diagonal-win ["X" 2 3 4 "X" 6 7 8 "X"]) true)))
  
  (testing "returns false if diagonal win doesn't exist"
    (is (= (diagonal-win [1 "X" 3 4 "X" 6 7 8 "X"]) false)))
  
  (testing "returns true if antidiagonal win exists"
    (is (= (antidiagonal-win [1 2 "X" 4 "X" 6 "X" 8 9]) true)))
  
  (testing "returns true if antidiagonal win doesn't exist"
    (is (= (antidiagonal-win [1 "X" 3 4 "X" 6 "X" 8 9]) false)))
  
  (testing "returns true if winner exists"
    (is (= (winner? ["X" "O" "O" "O" "X" "X" "X" "O" "X"]) true)))
  
  (testing "returns true if tie exists"
    (is (= (tie? ["X" "O" "O" "O" "X" "X" "X" "X" "O"]) true)))
  
  (testing "returns false if tie doesn't exist"
    (is (= (tie? ["X" "X" "X" "O" "O" "X" "X" "O" "O"]) false))))