(ns tic-tac-toe.minimax
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.rules :as rules]
            [tic-tac-toe.player :as player]))

(defn score [token]
  (cond
    (= token player/computer) 10
    (= token player/human) -10
    :else 0))

(defn score-board [board]
  (score (rules/winner board)))

(defn available-spaces [board]
  (for [x board
    :when (integer? x)]
  x))

(defn next-boards [board]
  (loop [move (available-spaces board)
         result []]
    (if (not-empty move)
    (recur
      (rest move)
      (conj result (board/update-board board (first move) (rules/turn board)))) result)))

(defn max-or-min [board scores]
  (if (= (rules/turn board) player/human)
    (apply min scores)
    (apply max scores)))

(defn evaluator [board]
  (if (rules/game-over? board)
    (score-board board)
    (loop [boards (next-boards board)
           result []]
      (if (not-empty boards)
        (recur
          (rest boards)
          (conj result (evaluator (first boards)))) (max-or-min board result)))))

(defn best-move [board]
  (loop [spaces (available-spaces board)
         boards (next-boards board)
         result {}]
           (if (not-empty spaces)
             (recur
               (rest spaces)
               (rest boards)
               (assoc result (first spaces) (evaluator (first boards))))
             (key (apply max-key val result)))))

(def minimax-fast
  (memoize (fn [n] (best-move n))))

; (defn modified-result [board]
;   (loop [term (next-boards board)
;          result []]
;     (if (not-empty term)
;       (recur
;         (rest term)
;         (conj result (result-analyzer (first term)))) (avg result))))
       
; (defn max-or-min [board scores]
;   (if (= (board/turn board) "X")
;     (apply min scores)
;     (apply max scores)))
  
; (if (number? (result-analyzer (first term))) (result-analyzer (first term) (modified-result (result-analyzer (first term)))))
; loop thru each term in a set
; (loop [spaces (available-spaces board)
;        ]
;        (reduce + whatever-collection-of-scores-you-eventually-get))
;        ;; maybe return avg?
;
; if term is not a number, then it's a board and continue processing
; (if (false? (number? term))
;     )
;
;   
    
  ; (reduce (fn [result inde] (println (str result "!#@$!09443"))) 7 board-scores)
  ; ))
  
; output scores for each available move
; if rules/game-over? is false,
;   (reduce + board-scores)
;   recur with next available move
;
;  
;

; figure out index of bestmove and output it

; see if minimax chooses winning move for a near-completed board
; start with testing a corner move
; units tests should reflect behavior of program
;   - corner move for first-best move
;   - middle move for 2nd-best move
;   - blocking a win
;   - completing a win
;   - multiple wins

; Given a collection of boards, return a list of next boards for each board

; (defn end-boards [board]
;   (loop [all-boards (next-boards board)
;          result []]
;     (if (not-empty all-boards)
;     (recur
;       (rest all-boards)
;       (conj result (board/update-board board (first move) (board/turn board)))) result))))

;(defn minimax) input: board output: move


;           "O"                    "O"                  ["X" "X" "O" 
;          /   \                /       \                 4  "O" "O" 
;        "O"   "O"             4(10)    6(0)             "X"  8  "X"]
;        / \   / \                        \
;      "O""O" "O""O"                      4(-10)
;
;                      [ 1  "X" "O" 
;                        4  "O"  6 
;                       "X" "O" "X"]
;
;
;





