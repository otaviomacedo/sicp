(ns sicp.cube
  (:use (clojure.contrib math))
  (:use sicp.main))

(defn- improve [guess n]
  (/ (+ (/ n (square guess)) (* 2 guess)) 3))

(defn- good-enough? [guess n]
  (<
    (abs (- (improve guess n) guess))
    (abs (* guess 0.001))))

(defn raiz-cubica [n]
  (loop [guess 1 n n]
    (if (good-enough? guess n)
      guess
      (recur (improve guess n) n))))