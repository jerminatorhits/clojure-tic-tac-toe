(ns tic-tac-toe.board
  (:gen-class))

(defn create-board 
  []
  (vec (range 1 10)))

(defn update-board
  [board location mark]
  (assoc board (- location 1) mark))