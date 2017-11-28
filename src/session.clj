(ns session
  (:gen-class))

(defn session-welcome
  []
  "Welcome to Tic-Tac-Toe! You will be 'X' and the computer will be 'O'\nThe spaces available are labeled 1 through 9.")

(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defn session-prompt
  []
  (println "Enter the space you wish to mark: ")
  (let [input (parse-int (read-line))]
  (if (and (and (>= input 1) (<= input 9)) integer?)
    (- input 1)
    "Invalid Input. Please enter a valid move: ")))