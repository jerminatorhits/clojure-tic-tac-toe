(ns tic-tac-toe.player-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.player :refer :all]))

(deftest player-test  
  (testing "provide random move"
    (is (= (contains? [1 2 3 4 5 6 7 8 9] (random-move)) true)))
  
  (testing "switch players"
    (is (= (switch-player human-player) computer-player))))