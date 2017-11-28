(ns display
  (:gen-class))

(defn stringify-board
  [board]
  (str "\n"
        " " (nth board 0) " | " (nth board 1) " | " (nth board 2) " " 
        "\n---|---|---\n" 
        " " (nth board 3) " | " (nth board 4) " | " (nth board 5) " " 
        "\n---|---|---\n" 
        " " (nth board 6) " | " (nth board 7) " | " (nth board 8) " "
        "\n"))

(defn display-board
  [board]
  (println (stringify-board board)))