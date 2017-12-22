(ns session
  (:gen-class)
    (require [session :refer :all])
    (require [display :refer :all])
    (require [board :refer :all]))

(defn session-welcome
  []
  "Welcome to Tic-Tac-Toe! You will be 'X' and the computer will be 'O'\nThe spaces available are labeled 1 through 9.")

(defn numeric? [s]
  (if-let [s (seq s)]
    (let [s (if (= (first s) \-) (next s) s)
          s (drop-while #(Character/isDigit %) s)
          s (if (= (first s) \.) (next s) s)
          s (drop-while #(Character/isDigit %) s)]
      (empty? s))))

(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defn session-prompt
  [msg]
  (display-text msg)
  (let [input (read-line)]
  (if (and (numeric? input) (and (>= (parse-int input) 1) (<= (parse-int input) 9)))
    (- (parse-int input) 1)
    (recur "Invalid Input. Please enter a valid move: "))))

(defn session-run
  []
  (println (session-welcome))
  (let [current-board (create-board)]
  (display-board current-board)
  (display-board (update-board current-board (session-prompt "Enter the space you wish to mark: ") "X"))))





















