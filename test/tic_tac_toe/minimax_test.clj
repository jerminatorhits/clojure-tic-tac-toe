(ns tic-tac-toe.minimax-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.minimax :refer :all]))

(deftest minimax-test
  (testing "returns 10 when 'O' wins"
    (is (= (score "O") 10)))
    
  (testing "returns -10 when 'X' wins"
    (is (= (score "X") -10)))
    
  (testing "returns 0 when no one wins"
    (is (= (score nil) 0)))

  (testing "returns list of available spaces to move"
    (is (= (available-spaces ["X" "X" "O" 
                               4  "O"  6 
                              "X" "O" "X"]) '(4 6))))
  
  (testing "returns a list of possible next boards"
    (is (= (next-boards ["X" "X" "O" 
                          4  "O"  6 
                         "X" "O" "X"]) 
                      '(["X" "X" "O" 
                         "O" "O"  6 
                         "X" "O" "X"] 
                        ["X" "X" "O" 
                          4  "O" "O" 
                         "X" "O" "X"]))))
  
  (testing "returns a list of possible next boards"
    (is (= (next-boards ["X" "X" "O"
                          4  "O"  6
                          7   8  "X"])
                      '(["X" "X" "O"
                         "O" "O"  6
                          7   8  "X"]
                        ["X" "X" "O"
                          4  "O" "O"
                          7   8  "X"]
                        ["X" "X" "O"
                          4  "O"  6
                         "O"  8  "X"]
                        ["X" "X" "O"
                          4  "O"  6
                          7  "O" "X"]))))
  
  (testing "blocks X from winning"
    (is (= (best-move [ 1   2  "X" 
                        4  "O"  6 
                        7   8  "X"]) 6)))
  
  (testing "returns winning move when 1 move away from winning"
    (is (= (best-move ["X" "X" "O" 
                        4  "O" "O" 
                       "X"  8  "X"]) 4)))
  
  (testing "returns max score given a vector of scores"
    (is (= (max-or-min ["X" "X" "O"
                        "O" "O" "X"
                         7   8  "X"] [10 0 1]) 10)))
  
  (testing "returns max score when it is computer's turn"
    (is (= (evaluator ["X" "X" "O"
                       "O" "O" "X"
                        7   8  "X"]) 10))))