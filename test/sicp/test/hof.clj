(ns sicp.test.hof
  (:use [sicp.hof])
  (:use [lazytest.describe])
  (:use [clojure.contrib.math]))

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

(describe "Accumulation with filtering"
  (it "sums the squares of the prime numbers in a given interval"
    (= 1014 (sum-of-squares-of-primes 5 20))))

(def inv-phi 0.618033989);1/phi, where phi is the golden ratio
(describe "Approximation of the 1/phi by a continued fraction"
  (it "is accurate to 4 decimal places using the iterative process"
    (< (abs (- inv-phi (cont-frac-iter (fn [i] 1.0) (fn [i] 1.0) 1000))) 0.0001)
  (it "is accurate to 4 decimal places using the recursive process"
    (< (abs (- inv-phi (cont-frac-recur (fn [i] 1.0) (fn [i] 1.0) 1000))) 0.0001 1))))

(def e 2.71828182845904523536028747135266249775724709369995)
(describe "Euler's expansion"
  (it "approximates e - 2"
    (< (abs (- (- e 2) (approximate-e)))) 0.00000001))

