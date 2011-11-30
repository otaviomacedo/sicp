(ns sicp.misc
  (:use (clojure.contrib math)))

(defn f-recur [n]
  (if (< n 3)
    n
    (+
      (f-recur (- n 1))
      (* (f-recur (- n 2)) 2)
      (* (f-recur (- n 3)) 3))))

(defn linear-combination [s1 s2]
  (reduce + (map * s1 s2)))

(defn f-iter [n]
  (def weights (range 3 0 -1))
  (if (< n 3)
    n
    (loop [x 3 previously-computed (conj clojure.lang.PersistentQueue/EMPTY 0 1 2)]
      (def value (linear-combination previously-computed weights))
      (if (= x n)
        value
        (recur (inc x) (conj (pop previously-computed) value))))))

(defn pascal-triangle [level column]
  (cond
    (or (zero? level) (zero? column) (= level column)) 1
    :else (+ (pascal-triangle (dec level) (dec column)) (pascal-triangle (dec level) column))))

(defn pascal-triangle-row [level]
  (map (partial pascal-triangle level) (range 0 (inc level))))


(defn apply-n [f base times]
  (loop [value base iteration 0]
    (if (= iteration times)
      value
      (recur (f value) (inc iteration)))))

(defn square [n]
  (*' n n))

(defn calculate-exp [base squares mults]
  (* (apply-n square base squares) (apply-n (partial * base) 1 mults)))

(defn exp-iter [base exponent squares mults]
  (cond
    (= exponent 0) 1
    (= exponent 1) (calculate-exp base squares mults)
    :else (if (even? exponent)
            (recur base (/ exponent 2) (inc squares) mults)
            (recur base (dec exponent) squares (inc mults)))))

(defn exp [base exponent]
  (exp-iter base exponent 0 0))

(defn exp-iter-naive [b counter product]
  (if (= counter 0)
    product
    (recur b
      (- counter 1)
      (*' b product))))


(println (exp 2 1000))
(println (exp-iter-naive 2 1000 1))
;(println (exp 2 1001))

