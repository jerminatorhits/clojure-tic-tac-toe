(ns tic-tac-toe.board
  (:gen-class))

(defn create-board []
  (vec (range 1 10)))

(defn turn [board]
  (let [occurences (frequencies board)]
        (if (= (get occurences "X") (get occurences "O")) "X" "O")))

(defn empty-space? [board move]
  (number? (nth board (- move 1))))

(defn update-board [board move mark]
  (assoc board (- move 1) mark))