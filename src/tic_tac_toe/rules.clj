(ns tic-tac-toe.rules
  (:gen-class)
    (require [tic-tac-toe.board :refer :all]))

(defn horizontal-win
  [board]
  (if (or 
      (= (count (distinct (subvec board 0 3))) 1)
      (= (count (distinct (subvec board 3 6))) 1)
      (= (count (distinct (subvec board 6 9))) 1))
    true
  false))
    