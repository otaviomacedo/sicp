(ns sicp.test.misc
  (:use [sicp.misc])
  (:use [lazytest.describe]))

(describe "Excercise 1.11 - recursive"
  (testing "Base conditions - returning the input value"
    (it "should return -1 for -1"
      (= -1 (f-recur -1)))
    (it "should return 2 for 2"
      (= 2 (f-recur 2))))
  (testing "recursive cases"
    (it "should return 4 for 3"
      (= 4 (f-recur 3)))
    (it "larger number"
      (= 1892 (f-recur 10)))))

(describe "Excercise 1.11 - iterative"
  (testing "Base conditions - returning the input value"
    (it "should return -1 for -1"
      (= -1 (f-iter -1)))
    (it "should return 2 for 2"
      (= 2 (f-iter 2))))
  (testing "recursive cases"
    (it "should return 4 for 3"
      (= 4 (f-iter 3)))
    (it "larger number"
      (= 1892 (f-iter 10)))))

(describe "Pascal triangle"
  (testing "Rows"
    (it "has only the number 1 at first column"
      (= '(1) (pascal-triangle-row 0)))
    (it "has two 1s at second colum"
      (= '(1 1) (pascal-triangle-row 1)))
    (it "has intermediate elements as the sum of the two numbers above it"
      (= '(1 2 1) (pascal-triangle-row 2)))
    (it "has intermediate elements as the sum of the two numbers above it"
      (= '(1 3 3 1) (pascal-triangle-row 3)))
    (it "has intermediate elements as the sum of the two numbers above it"
      (= '(1 4 6 4 1) (pascal-triangle-row 4)))
    ))

(describe "Exponentiation - iterative process"
  (it "base condition: result = 1"
    (= 1 (exp 3 0)))
  (it "odd exponent"
    (= 81 (exp 3 4))))