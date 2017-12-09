(ns tic-tac-toe.session
  (:require [tic-tac-toe.display :refer :all]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.player :refer :all]
            [tic-tac-toe.rules :refer :all]
            [tic-tac-toe.messages :refer :all]))

(defn validate-integer [entry]
  (and (number? entry) (>= entry 1) (<= entry 9)))

(defn empty-space? [board move]
  (number? (nth board (- move 1))))

(defn valid-move? [board move]
  (and (validate-integer move) (empty-space? board move)))

(defn String->Number [str]
  (let [n (read-string str)]
    (if (number? n) n nil)))

(defn session-turn
  [board current-player]
  (if (= current-player "X")
    (let [move (String->Number (read-line))]
    (if (false? (valid-move? board move))
      (display-text invalid-message))
    (if (valid-move? board move)
      (update-board board move current-player)
    (recur board current-player)))
  (let [move (random-move)]
    (if (valid-move? board move)
      (update-board board move current-player)
    (recur board current-player)))))
  
(defn session-run []
  (display-text welcome-message)
  (loop [board (create-board) current-player human-player]
    (display-board board)
    (cond
      (tie? board) (display-text tie-message)
      (winner? board) (display-text winner-message))
    (when (false? (game-over? board))
      (if (= human-player current-player)
        (display-text human-turn-message)
        (display-text computer-turn-message))
      (display-text "\n"))
    (recur (session-turn board current-player) (switch-player current-player))))
