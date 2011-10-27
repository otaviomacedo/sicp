(ns sicp.test.fibonaccitest
  (:use [sicp.fibonacci])
  (:use [lazytest.describe]))

(describe "Fibonacci function"
  (it "returns 0 for input 0"
    (= 0 (fibonacci 0)))
  (it "returns 1 for input 1"
    (= 1 (fibonacci 1)))
  (it "returns the sum of the two preceding fibonacci values"
    (= 1 (fibonacci 2)))
  (it "returns the sum of the two preceding fibonacci values for a larger number"
    (= 5 (fibonacci 5)))
  (it "calculates the value for an enormous input"
    (= 280571172992510140037611932413038677189525 (fibonacci 200)))
  )


