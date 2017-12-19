(ns tic-tac-toe.session
  (:require [tic-tac-toe.display :as display]
            [tic-tac-toe.board :as board]
            [tic-tac-toe.player :as player]
            [tic-tac-toe.rules :as rules]
            [tic-tac-toe.minimax :as minimax]
            [tic-tac-toe.messages :as messages]))

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
      (display/display-text messages/invalid))
    (if (valid-move? board move)
      (board/update-board board move current-player)
    (recur board current-player)))
  (let [move (minimax/best-move board)]
    (if (valid-move? board move)
      (board/update-board board move current-player)
    (recur board current-player)))))
  
(defn session-run []
  (display/display-text messages/welcome)
  (loop [board (board/create-board) current-player player/human-player]
    (display/display-board board)
    (cond
      (rules/tie? board) (display/display-text messages/tie)
      (rules/winner board) (display/display-text messages/winner))
    (when (false? (rules/game-over? board))
      (if (= player/human-player current-player)
        (display/display-text messages/human-turn)
        (display/display-text messages/computer-turn))
      (display/display-text "\n"))
    (recur (session-turn board current-player) (player/switch-player current-player))))
