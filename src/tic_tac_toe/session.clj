(ns tic-tac-toe.session
  (:require [tic-tac-toe.display :as display]
            [tic-tac-toe.board :as board]
            [tic-tac-toe.player :as player]
            [tic-tac-toe.rules :as rules]
            [tic-tac-toe.minimax :as minimax]
            [tic-tac-toe.messages :as messages]))

(defn validate-integer [entry]
  (and (number? entry) (>= entry 1) (<= entry 9)))

(defn valid-move? [board move]
  (if-not (and (validate-integer move) (board/empty-space? board move))
    (display/text messages/invalid))
  (and (validate-integer move) (board/empty-space? board move)))

(defn String->Number [string]
  (let [n (read-string string)]
    (if (number? n) n nil)))

(defn get-input [board current-player]
  (if (= current-player player/human)
    (String->Number (read-line))
    (minimax/minimax-fast board)))

(defn session-turn [board current-player]
  (let [move (get-input board current-player)]
      (if (valid-move? board move)
        (board/update-board board move current-player)
        (recur board current-player))))

(defn end-game [board]
  (if (rules/tie? board)
    (display/text messages/tie)
    (display/text (str (rules/winner board) messages/winner)))
  (display/text "\n\n"))

(defn session-run []
  (display/text messages/welcome)
  (loop [board (board/create-board) current-player player/human]
    (display/board board)
    (if (rules/game-over? board)
      (end-game board)
      (when (false? (rules/game-over? board))
        (if (= player/human current-player)
          (display/text messages/human-turn)
          (display/text messages/computer-turn))
        (recur (session-turn board current-player) (player/switch current-player))))))