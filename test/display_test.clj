(ns display-test
  (:require [clojure.test :refer [deftest testing is]]
            [display :refer :all]
            [board :refer :all]))

(deftest display-test
  (testing "makes board into a formatted string"
    (is (= (stringify-board (create-board)) "\n 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n")))

  (testing "prints board out to the console"
   (is (= (display-board (stringify-board (create-board))) (println (stringify-board (create-board)))))))

;;  (testing "updates board when given a location and mark"
;;    (is (= [:X 2 3 4 5 6 7 8 9] (update-board [1 2 3 4 5 6 7 8 9] 0 :X))))

;;  (testing "formats board into presentable string when given a board"
;;    (is (= (format-board [1 2 3 4 5 6 7 8 9]) "\n 1 | 2 | 3 \n---|---|---\n 4 | 5 | 6 \n---|---|---\n 7 | 8 | 9 \n")))