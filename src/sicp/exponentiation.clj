(ns sicp.exponentiation)


(defn double-number [a]
  (+' a a))

(defn halve [a]
  (/ a 2))

(defn multiply [m n]
  (loop [s 0 a m b n]
    (cond
      (zero? b) s
      (even? b) (recur s (double-number a) (halve b))
      :else (recur (+' s a) a (dec b)))))

(defn multiply-naive [m n]
  (if (or (zero? m) (zero? n))
    0
    (loop [a m b n]
      (if (zero? b)
        (- a m)
        (recur (+' a m) (dec b))))))

(def a 388123712)
(def b 316341672)
(println (time (multiply a b)))
(println (time (multiply-naive a b)))