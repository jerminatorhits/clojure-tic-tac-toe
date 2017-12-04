(ns tic-tac-toe.session-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.session :refer :all]))

(deftest session-test
  (testing "prints welcome message upon start"
    (is (session-welcome) "Welcome to Tic-Tac-Toe! You will be 'X' and the computer will be 'O'\nThe spaces available are labeled 1 through 9. Enter the space you wish to mark."))
  
  (testing "prompts player for a valid move at the beginning of the turn"
    (is (with-in-str "1" (session-prompt "Enter the space you wish to mark: ")) 0))

  (testing "prompts player for a valid move if invalid move is provided"
    (is (with-in-str "p\n1" (session-prompt "Enter the space you wish to mark: ")) 0)))