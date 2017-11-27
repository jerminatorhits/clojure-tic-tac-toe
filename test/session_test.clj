(ns session-test
  (:require [clojure.test :refer [deftest testing is]]
            [session :refer :all]))

(deftest session-test
  (testing "prints welcome message upon start"
    (is (session-start) "Welcome to Tic-Tac-Toe! You will be 'X' and the computer will be 'O'\nThe spaces available are labeled 1 through 9. Enter the space you wish to mark.")))
