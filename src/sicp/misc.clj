(ns sicp.misc)

(defn f [n]
  (if (< n 3)
    n
    (+
      (f (- n 1))
      (* (f (- n 2)) 2)
      (* (f (- n 3)) 3))))

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


