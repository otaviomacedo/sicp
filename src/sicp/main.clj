(ns sicp.main
  (:use (clojure.contrib math)))

(defn new-if [predicate then-clause else-clause]
  (cond
    predicate then-clause
    :else else-clause))

(defn square [n]
  (* n n))

(defn sq-improve [guess n]
  (/ (+ (/ n guess) guess) 2))

(defn sq-good-enough? [guess n]
  (< (abs (- (sq-improve guess n) guess))
    (abs (* guess 0.0001))))

(defn raiz-quadrada [n]
  (loop [guess 1 n n]
    (if (sq-good-enough? guess n)
      guess
      (recur (sq-improve guess n) n))))

(println "raiz quadrada" (raiz-quadrada 249238492842908429849275847227434728472398432437928428748738482744674658237423647823874387.0))
(println "raiz quadrada" (raiz-quadrada 0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001))
;------------------------------------------------------------

(defn cube [n]
  (* n (square n)))

(defn improve-cube [guess n]
  (/ (+ (/ n (square guess)) (* 2 guess)) 3))

(defn cube-good-enough? [guess n]
  (<
    (abs (- (improve-cube guess n) guess))
    (abs (* guess 0.001))))

(defn raiz-cubica [n]
  (loop [guess 1 n n]
    (if (cube-good-enough? guess n)
      guess
      (recur (improve-cube guess n) n))))

(println "raiz cubica" (raiz-cubica 272908429848274236570264209842842758325772837484874234710748374874676765723083436.0))
(println "raiz cubica" (raiz-cubica 0.000000000000000000000000000000000000000000000000000000000000000000000000000001))