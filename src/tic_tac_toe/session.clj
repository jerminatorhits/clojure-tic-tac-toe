(ns tic-tac-toe.session
  (:gen-class)
    (require [tic-tac-toe.display :refer :all])
    (require [tic-tac-toe.board :refer :all])
    (require [tic-tac-toe.player :refer :all])
    (require [tic-tac-toe.rules :refer :all]))

(def session-welcome
  "\nWelcome to Tic-Tac-Toe! You will be 'X' and the computer will be 'O'\nThe spaces available are labeled 1 through 9.\n")

(def turn-message
  "Enter the space you wish to mark: ")

(defn validate-integer
  [entry]
  (and (number? entry) (>= entry 1) (<= entry 9)))

(defn empty-space?
  [board move]
  (number? (nth board (- move 1))))

(defn valid-move?
  [board move]
  (and (validate-integer move) (empty-space? board move)))

(defn String->Number [str]
  (let [n (read-string str)]
       (if (number? n) n nil)))

(defn session-turn
  [board player]
  (let [move (String->Number (read-line))]
  (if (false? (valid-move? board move))
    (display-text "Invalid Input. Please enter a valid move: ")
  )
  (if (valid-move? board move)
    (update-board board move player)
  (recur board player))))

(defn session-run
  []
  (display-text session-welcome)
  ;(loop [current-board (create-board) human (create-player "X") computer (create-player "O") current-player human]
    ;(display-board current-board)
    ;(when (and (false? (winner? current-board)) (false? (tie? current-board)))
      ;(if (= human current-player)
        ;(do
        ;  (display-text turn-message)
        ;  (update-board current-board (session-prompt "Enter the space you wish to mark: ") human)
        ;)
        ;(update-board current-board
        )
  ;(let [current-board (create-board) human (create-player "X") computer (create-player "O") current-player human]
  ;  (display-board current-board)
  ;  (display-board (update-board current-board (session-prompt "Enter the space you wish to mark: ") current-player)))


; turn [player]
; if it's a human, do this

; if it's a computer, do this













