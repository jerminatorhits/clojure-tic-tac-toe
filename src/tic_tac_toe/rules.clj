(ns tic-tac-toe.rules
    (require [tic-tac-toe.board :refer :all]))

(defn horizontal-win [board token]
  (if
   (or 
    (= token (apply str (distinct (subvec board 0 3))))
    (= token (apply str (distinct (subvec board 3 6))))
    (= token (apply str (distinct (subvec board 6 9)))))
    token))

(defn vertical-win [board token]
  (if
   (or 
    (= token (apply str (distinct (take-nth 3 board))))
    (= token (apply str (distinct (take-nth 3 (drop 1 board)))))
    (= token (apply str (distinct (take-nth 3 (drop 2 board))))))
    token))

(defn diagonal-win [board token]
  (if (= (nth board 0) (nth board 4) (nth board 8) token) token))

(defn antidiagonal-win [board token]
  (if (= (nth board 2) (nth board 4) (nth board 6) token) token))

(defn winner? [board token]
  (if
   (or
    (= token (horizontal-win board token))
    (= token (vertical-win board token))
    (= token (diagonal-win board token))
    (= token (antidiagonal-win board token)))
    token
    false))

(defn tie? [board token]
  (and (false? (winner? board token)) (true? (nil? (some number? board)))))

(defn game-over? [board]
  (or (winner? board) (tie? board)))
