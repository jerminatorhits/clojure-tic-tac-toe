(ns tic-tac-toe.core
  (:gen-class)
  (require [session :refer :all])
  (require [board :refer :all]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (session-welcome))
  (println (format-board board))
  (session-prompt))
