(ns tic-tac-toe.board
  (:gen-class))

(defn create-board []
  (vec (range 1 10)))

(defn empty-space? [board move]
  (number? (nth board (- move 1))))

(defn update-board [board move mark]
  (assoc board (- move 1) mark))