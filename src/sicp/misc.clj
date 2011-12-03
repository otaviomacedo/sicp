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

(defn apply-stack [base stack]
  (loop [s stack value 1]
    (if (empty? s)
      value
      (recur (rest s) ((first s) value)))))

(defn exp-stack [base exponent]
  (loop [e exponent stack (list)]
    (cond
      (zero? e) (apply-stack base stack)
      (even? e) (recur (/ e 2) (cons square stack))
      :else (recur (dec e) (cons (partial *' base) stack)))))


(defn exp-iter-naive [b counter product]
  (if (= counter 0)
    product
    (recur b
      (- counter 1)
      (*' b product))))

(defn exp-smart [base exponent]
  (loop [a 1 b base n exponent]
    (cond
      (zero? n) a
      (even? n) (recur a (square b) (/ n 2))
      :else (recur (*' a b) b (dec n)))))

(defn exp [base exponent]
  (exp-iter-naive base exponent 1))


(def base 19)
(def exponent 104709)
(println (time (exp-iter-naive base exponent 1)))
(println (time (exp-stack base exponent )))
(println (time (exp-smart base exponent )))

