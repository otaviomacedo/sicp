(ns sicp.test.test
  (:use [sicp.main])
  (:use [clojure.test]))

(deftest new-if-test
  (is (= 1 (new-if (= 2 2) 1 0))))

