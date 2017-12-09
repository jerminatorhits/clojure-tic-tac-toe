(ns tic-tac-toe.board
  (:gen-class))

(defn create-board 
  []
  ;["X" "O" "X"
  ; "O" "O" "X"
  ; "X" "X" "O"])
  (vec (range 1 10)))

(defn update-board
  [board location mark]
  (assoc board (- location 1) mark))