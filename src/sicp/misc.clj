(ns sicp.misc)

(defn f [n]
  (if (< n 3)
    n
    (+
      (f (- n 1))
      (* (f (- n 2)) 2)
      (* (f (- n 3)) 3))))

(defn reduce-previous [window]
  (+ (* 3 (nth window 0)) (* 2 (nth window 1) (nth window 2))))

(def base-window )

(defn f-iter [n]
  (if (< n 3)
    n
    (loop [x 3 window (clojure.lang.PersistentQueue/EMPTY)]
      (def value (reduce-previous window))
      (if (= x n)
        value
        (recur (inc x) (conj value (rest window)))))))

(println (f-iter 4))