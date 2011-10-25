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
(println "raiz quadrada" (raiz-quadrada 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.1))
;------------------------------------------------------------

;(defn cube [n]
;  (* n (square n)))
;
;(defn cube-good-enough? [guess n]
;  (< (abs (- (cube guess) n)) 0.00001))
;
;(defn improve-cube [guess n]
;  )
;
;(defn raiz-cubica [n]
;  (loop [guess 1 n n]
;    (if (cube-good-enough? guess n)
;      guess
;      (recur (improve-cube guess n)))))
;
