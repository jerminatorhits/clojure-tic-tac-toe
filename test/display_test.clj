(ns display-test
  (:require [clojure.test :refer [deftest testing is]]
            [display :refer :all]
            [board :refer :all]))

(deftest display-test
  (testing "makes board into a formatted string"
    (is (= (stringify-board (create-board)) "\n 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n")))

  (testing "prints board out to the console"
    (is (= (display-text (stringify-board (create-board))) (println (stringify-board (create-board))))))
  
  (testing "prints board text to the console"
    (is (= (display-text "Testing") (println "Testing")))))