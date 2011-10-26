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

(println "raiz cubica" (raiz-cubica 272908429848274236570264209842842758325772837484874234710748374874676765723083436.0))
(println "raiz cubica" (raiz-cubica 0.000000000000000000000000000000000000000000000000000000000000000000000000000001))
