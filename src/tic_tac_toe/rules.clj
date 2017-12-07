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

(defn vertical-win
  [board]
  (if (or 
      (= (count (distinct (take-nth 3 board))) 1)
      (= (count (distinct (take-nth 3 (drop 1 board)))) 1)
      (= (count (distinct (take-nth 3 (drop 2 board)))) 1))
    true
  false))

(defn diagonal-win
  [board]
  (= (nth board 0) (nth board 4) (nth board 8)))

(defn antidiagonal-win
  [board]
  (= (nth board 2) (nth board 4) (nth board 6)))

(defn winner?
  [board]
  (or (horizontal-win board) (vertical-win board) (diagonal-win board) (antidiagonal-win board)))

(defn tie?
  [board]
  (and (false? (winner? board)) (true? (nil? (some number? board)))))
