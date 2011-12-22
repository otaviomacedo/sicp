(ns sicp.square
  (:use (clojure.contrib math))
  (:use sicp.main))

(defn- improve [guess n]
  (/ (+ (/ n guess) guess) 2))

(defn- good-enough? [guess n]
  (< (abs (- (improve guess n) guess))
    (abs (* guess 0.0001))))

(defn raiz-quadrada [n]
  (loop [guess 1 n n]
    (if (good-enough? guess n)
      guess
      (recur (improve guess n) n))))
