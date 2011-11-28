(ns sicp.test.misc
  (:use [sicp.misc])
  (:use [lazytest.describe]))

(describe "Excercise 1.11 - recursive"
  (testing "Base conditions - returning the input value"
    (it "should return -1 for negative -1"
      (= -1 (f -1)))
    (it "should return 2 for 2"
      (= 2 (f 2))))
  (testing "recursive cases"
    (it "should return 4 for 3"
      (= 4 (f 3)))
    (it "larger number"
      (= 1892 (f 10)))))

(describe "Excercise 1.11 - iterative"
  (testing "Base conditions - returning the input value"
    (it "should return -1 for negative -1"
      (= -1 (f-iter -1)))
    (it "should return 2 for 2"
      (= 2 (f-iter 2))))
  (testing "recursive cases"
    (it "should return 4 for 3"
      (= 4 (f-iter 3)))
    (it "larger number"
      (= 1892 (f-iter 10)))))

