(ns tic-tac-toe.player
  (:gen-class))

(defn create-player
  [token]
  token)

(defn provide-move
  [number]
  number)

(defn random-move
  []
  (+ (rand-int 8) 1))