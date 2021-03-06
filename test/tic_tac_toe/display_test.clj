(ns tic-tac-toe.display-test
  (:require [clojure.test :refer [deftest testing is]]
            [tic-tac-toe.display :as display]
            [tic-tac-toe.board :refer :all]))

(deftest display-test
  (testing "makes board into a formatted string"
    (is (= (display/stringify-board (create-board)) "\n 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n\n")))

  (testing "prints board out to the console"
    (is (= (display/text (display/stringify-board (create-board))) (println (display/stringify-board (create-board))))))
  
  (testing "prints board text to the console"
    (is (= (display/text "Testing") (println "Testing")))))