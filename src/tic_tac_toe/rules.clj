(ns tic-tac-toe.rules)

(defn horizontal-win [board]
  (cond
    (= (count (distinct (subvec board 0 3))) 1) (nth board 0)
    (= (count (distinct (subvec board 3 6))) 1) (nth board 3)
    (= (count (distinct (subvec board 6 9))) 1) (nth board 6)))

(defn vertical-win [board]
  (cond
    (= (count (distinct (take-nth 3 board))) 1) (nth board 0)
    (= (count (distinct (take-nth 3 (drop 1 board)))) 1) (nth board 1)
    (= (count (distinct (take-nth 3 (drop 2 board)))) 1) (nth board 2)))

(defn diagonal-win [board]
  (if (= (nth board 0) (nth board 4) (nth board 8)) (nth board 0)))

(defn antidiagonal-win [board]
  (if (= (nth board 2) (nth board 4) (nth board 6)) (nth board 2)))

(defn winner [board]
  (or (horizontal-win board) (vertical-win board) (diagonal-win board) (antidiagonal-win board)))

(defn tie? [board]
  (and (nil? (winner board)) (true? (nil? (some number? board)))))

(defn game-over? [board]
  (or (some? (winner board)) (tie? board)))

(defn turn [board]
  (let [occurences (frequencies board)]
        (if (= (get occurences "X") (get occurences "O")) "X" "O")))