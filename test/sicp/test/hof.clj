(ns sicp.test.hof
  (:use [sicp.hof])
  (:use [lazytest.describe]))

(def precision 0.00001)
(describe "Cube integration by naive method"
  (it "approximates to 1/4 by a within a certain precision"
    (<= (- (integral cube 0 1 precision) 0.25) precision)))

(describe "Cube integration by Simpson's method"
  (it "equals to 1/4 after a certain number of iterations"
    (= 0.25 (simpsons-rule cube 0 1 2))))

(describe "Factorial using generic product function"
  (it "calculates factorial for small numbers"
    (= 120 (factorial 5)))
  (it "calculates factorial for large numbers"
    (= 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
      (factorial 100))))
