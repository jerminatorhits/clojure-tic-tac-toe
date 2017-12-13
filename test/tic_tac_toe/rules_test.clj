(ns tic-tac-toe.rules-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.rules :refer :all]))

(deftest rules-test
  (testing "returns token if given 3 in a row horizontally"
    (is (= (horizontal-win ["X" "X" "X" 4 5 6 7 8 9] "X") "X")))
  
  (testing "returns token if given 3 in a row horizontally"
    (is (= (horizontal-win [1 2 3 "X" "X" "X" 7 8 9] "X") "X")))
  
  (testing "returns token if given 3 in a row horizontally"
    (is (= (horizontal-win [1 2 3 4 5 6 "O" "O" "O"] "O") "O")))

  (testing "returns token if given no horizontal win"
    (is (= (horizontal-win [1 "X" "X" "X" 5 6 7 8 9] "X") nil)))
  
  (testing "returns token if given 3 in a row vertically"
    (is (= (vertical-win ["X" 2 3 "X" 5 6 "X" 8 9] "X") "X")))
  
  (testing "returns true if given 3 in a row vertically"
    (is (= (vertical-win [1 "O" 3 4 "O" 6 7 "O" 9] "O") "O")))
  
  (testing "returns true if given 3 in a row vertically"
    (is (= (vertical-win [1 2 "X" 4 5 "X" 7 8 "X"] "X") "X")))
  
  (testing "returns false if given no vertical win"
    (is (= (vertical-win [1 "X" 3 "X" 5 6 "X" 8 9] "X") nil)))
  
  (testing "returns true if diagonal win exists"
    (is (= (diagonal-win ["X" 2 3 4 "X" 6 7 8 "X"] "X") "X")))
  
  (testing "returns false if diagonal win doesn't exist"
    (is (= (diagonal-win [1 "O" 3 4 "O" 6 7 8 "O"] "O") nil)))
  
  (testing "returns true if antidiagonal win exists"
    (is (= (antidiagonal-win [1 2 "O" 4 "O" 6 "O" 8 9] "O") "O")))
  
  (testing "returns true if antidiagonal win doesn't exist"
    (is (= (antidiagonal-win [1 "X" 3 4 "X" 6 "X" 8 9] "X") nil)))
  
  (testing "returns true if winner exists"
    (is (= (winner? ["X" "O" "O" "O" "X" "X" "X" "O" "X"] "X") "X")))
  
  (testing "returns true if winner exists"
    (is (= (winner? ["O" "X" "O" "O" "X" "X" "X" "O" "X"] "O") false)))
  
  (testing "returns true if tie exists"
    (is (= (tie? ["X" "O" "O" "O" "X" "X" "X" "X" "O"] "X") true)))
  
  (testing "returns false if tie doesn't exist"
    (is (= (tie? ["X" "X" "X" "O" "O" "X" "X" "O" "O"] "X") false))))