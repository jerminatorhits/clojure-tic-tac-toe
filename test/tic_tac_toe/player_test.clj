(ns tic-tac-toe.player-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.player :refer :all]))

(deftest player-test
  (testing "creates player with a given token"
    (is (= (create-player "X") "X")))
  
  (testing "provides location of move"
    (is (= (provide-move 3) 3))))