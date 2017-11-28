(ns tic-tac-toe.core
  (:gen-class)
  (require [session :refer :all])
  (require [board :refer :all])
  (require [display :refer :all]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (session-welcome))
  (let [current-board (create-board)]
  (display-board current-board)
  (display-board (update-board current-board (session-prompt "Enter the space you wish to mark: ") "X"))))