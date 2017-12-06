(ns tic-tac-toe.session
  (:gen-class)
    (require [tic-tac-toe.display :refer :all])
    (require [tic-tac-toe.board :refer :all]))

(defn session-welcome
  []
  "\nWelcome to Tic-Tac-Toe! You will be 'X' and the computer will be 'O'\nThe spaces available are labeled 1 through 9.")

(defn validate-entry
  [entry]
  (and (number? entry) (and (>= entry 1) (<= entry 9))))

(defn String->Number [str]
  (let [n (read-string str)]
       (if (number? n) n nil)))

(defn session-prompt
  [msg]
  (display-text msg)
  (let [input (String->Number (read-line))]
  (if (validate-entry input)
    (- input 1)
    (recur "Invalid Input. Please enter a valid move: "))))

(defn session-run
  []
  (display-text (session-welcome))
  (let [current-board (create-board)]
  (display-board current-board)
  (display-board (update-board current-board (session-prompt "Enter the space you wish to mark: ") "X"))))





















