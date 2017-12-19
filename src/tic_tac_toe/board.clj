(ns tic-tac-toe.board
  (:gen-class))

(defn create-board []
  (vec (range 1 10)))

(defn turn [board]
  (let [occurences (frequencies board)]
        (if (= (get occurences "X") (get occurences "O")) "X" "O")))

(defn update-board [board location mark]
  (assoc board (- location 1) mark))