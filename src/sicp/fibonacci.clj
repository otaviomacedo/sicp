(ns sicp.fibonacci
  (:use (clojure.contrib math)))

(defn fibonacci [n]
  (loop [a 0 b 1 counter 0]
    (if (= counter n)
      a
      (recur b (+' a b) (inc counter)))))

(defn square [n] (*' n n))

(def primitives {0 0, 1 1, 2 1})

(defn sum-of-squares [a b]
  (+' (square a) (square b)))

;TODO rename
(defn function-a [lesser greater]
  (*' greater (+ (* 2 lesser) greater)))

;TODO rename
(defn function-c [lesser greater]
  (*' lesser (- (* 2 greater) lesser)))

(defn half [n]
  (if (even? n)
    (/ n 2)
    (/ (inc n) 2)))

(defn make-stack [n]
  (loop [stack (list) head n]
    (if (= 2 head)
      stack
      (recur (cons head stack) (half head)))))

(defn fib-stack [lesser greater stack]
  (cond
    (empty? stack) greater
    (even? (first stack)) (recur
                            (sum-of-squares lesser greater)
                            (function-a lesser greater)
                            (rest stack))
    :else (recur
            (function-c lesser greater)
            (sum-of-squares lesser greater)
            (rest stack))))

(defn fib-smart
  "This is not the algorithm expected by Exercise 1.19 and it is unquestionably more
  convoluted than theirs. Nonetheless, this algorithm's complexity is O(log n) both
  in time and space. If you are interested in knowing why it works, see the explanation
  at doc/fibonacci.tex."
  [n]
  (def candidate (primitives n))
  (if candidate
    candidate
    (fib-stack 1 1 (make-stack n))))

(def n 10)
(println (time (fib-smart n)))
(println (time (fibonacci n)))
