(ns sicp.main
  (:use (clojure.contrib math)))

(defn new-if [predicate then-clause else-clause]
  (cond
    predicate then-clause
    :else else-clause))

(defn square [n]
  (* n n))

(defn cube [n]
  (* n (square n)))

(defn factorial
  ([n] (factorial (dec n) n n))
  ([counter product n]
    (if (= counter 1)
      product
      (recur (dec counter) (* product counter) n))))

(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1) (A x (- y 1)))))
