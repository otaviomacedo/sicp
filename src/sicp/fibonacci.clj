(ns sicp.fibonacci)

(defn fibonacci [n]
  (loop [a 0 b 1 counter 0]
    (if (= counter n)
      a
      (recur b (+' a b) (inc counter)))))