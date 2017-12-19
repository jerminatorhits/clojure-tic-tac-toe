(ns tic-tac-toe.player)

(def human "X")
(def computer "O")

(defn random-move []
  (+ (rand-int 8) 1))

(defn switch [current-player]
  (cond
    (= current-player human) computer
    (= current-player computer) human))