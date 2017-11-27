(ns board-test
  (:require [clojure.test :refer [deftest testing is]]
            [board :refer :all]))

(deftest board-test
  (testing "creates an empty board"
    (is (= [1 2 3 4 5 6 7 8 9] (create-board))))

  (testing "updates board when given a location and mark"
    (is (= [:X 2 3 4 5 6 7 8 9] (update-board [1 2 3 4 5 6 7 8 9] 0 :X)))))
