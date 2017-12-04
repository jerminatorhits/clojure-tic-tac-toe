(ns tic-tac-toe.rules-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.rules :refer :all]))

(deftest rules-test
  (testing "returns true if given 3 in a row horizontally"
    (is (= (horizontal-win ["X" "X" "X" 4 5 6 7 8 9]) true)))

  (testing "returns false if given 3 in a row horizontally"
    (is (= (horizontal-win [1 "X" "X" "X" 5 6 7 8 9]) false))))