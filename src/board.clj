(ns board
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a litto teapot!"))

(def board [1 2 3 4 5 6 7 8 9])

(defn create-board
  []
  [1 2 3 4 5 6 7 8 9])

(defn update-board
  [board location mark]
  (assoc board location mark))