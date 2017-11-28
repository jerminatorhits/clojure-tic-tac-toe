(ns board
  (:gen-class))

(def board [1 2 3 4 5 6 7 8 9])

(defn create-board
  []
  [1 2 3 4 5 6 7 8 9])

(defn update-board
  [board location mark]
  (assoc board location mark))

(defn format-board
  [board]
  (str  "\n"
        " " (nth board 0) " | " (nth board 1) " | " (nth board 2) " " 
        "\n---|---|---\n" 
        " " (nth board 3) " | " (nth board 4) " | " (nth board 5) " " 
        "\n---|---|---\n" 
        " " (nth board 6) " | " (nth board 7) " | " (nth board 8) " "
        "\n"))