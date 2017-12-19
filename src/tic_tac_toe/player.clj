(ns tic-tac-toe.player)

(def human-player "X")
(def computer-player "O")

(defn random-move []
  (+ (rand-int 8) 1))

(defn switch-player [current-player]
  (cond
    (= current-player human-player) computer-player
    (= current-player computer-player) human-player))