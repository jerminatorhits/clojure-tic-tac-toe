(ns tic-tac-toe.player-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.player :as player]))

(deftest player-test  
  (testing "provides random move"
    (is (= (contains? [1 2 3 4 5 6 7 8 9] (player/random-move)) true)))
  
  (testing "switches players"
    (is (= (player/switch player/human) player/computer))))