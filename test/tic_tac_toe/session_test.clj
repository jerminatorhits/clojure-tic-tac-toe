(ns tic-tac-toe.session-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.session :refer :all]))

(deftest session-test
  (testing "validates input from player correctly"
    (is (= (validate-integer 1) true)))
  
  (testing "validates input from player correctly"
    (is (= (validate-integer 0) false)))
  
  (testing "validates input from player correctly"
    (is (= (validate-integer -1) false)))
  
  (testing "validates input from player correctly"
    (is (= (validate-integer "a") false)))
  
  (testing "prompts player for a valid move at the beginning of the turn"
    (is (with-in-str "1" (session-turn [1 2 3 4 5 6 7 8 9] "X")) ["X" 2 3 4 5 6 7 8 9]))

  (testing "prompts player for a valid move if invalid move is provided"
    (is (with-in-str "p\n1" (session-turn [1 2 3 4 5 6 7 8 9] "X")) ["X" 2 3 4 5 6 7 8 9])))