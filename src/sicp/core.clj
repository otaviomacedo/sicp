(ns sicp.core
  (:use (clojure.contrib math)))

(defn square [n]
  (* n n))

(defn good-enough? [guess n]
  (< (abs (- (square guess) n)) 0.000001))

(defn improve [guess n]
  (/ (+ (/ n guess) guess) 2))

(defn raiz-quadrada [n]
  (loop [guess 1 n n]
    (if (good-enough? guess n)
      guess
      (recur (improve guess n) n))))

(print (raiz-quadrada 2.0))