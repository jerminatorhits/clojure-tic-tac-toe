(ns tic-tac-toe.display)

(defn stringify-board
  [board]
  (str "\n"
        " " (nth board 0) " | " (nth board 1) " | " (nth board 2) " " 
        "\n---|---|---\n" 
        " " (nth board 3) " | " (nth board 4) " | " (nth board 5) " " 
        "\n---|---|---\n" 
        " " (nth board 6) " | " (nth board 7) " | " (nth board 8) " "
        "\n\n"))

(defn display-text
  [text]
  (print text)
  (flush))

(defn display-board
  [board]
  (display-text (stringify-board board)))