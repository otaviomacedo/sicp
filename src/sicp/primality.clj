(ns sicp.primality
  (:use (clojure.contrib math))
  (:use sicp.exponentiation))

(defn divides? [a b]
  (= (rem b a) 0))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (recur n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(defn report-prime [elapsed-time]
  (println " *** ")
  (println elapsed-time))

(defn start-prime-test [n start-time]
  (if (prime? n)
      (report-prime (- (System/currentTimeMillis) start-time))))

(defn timed-prime-test [n]
  (println n)
  (start-prime-test n (System/currentTimeMillis)))


(defn search-for-primes-odd [lower-bound]
  (loop [n lower-bound count 0]
    (cond
      (= 3 count) 0
      (prime? n) (timed-prime-test n)
      :else (recur (+ 2 n) (inc count)))))

(defn search-for-primes [lower-bound]
  (if (even? lower-bound)
    (search-for-primes-odd (inc lower-bound))
    (search-for-primes-odd lower-bound)))

;TODO write this as a test
;(search-for-primes 10000000000)