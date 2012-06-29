(ns sicp.change
  (:use [clojure.set]))

(def values '(1, 5, 10, 25, 50))

(defn value-of [coin]
  (nth values coin))

(defn change-count-recursive [amount coin]
  (cond
    (neg? amount) 0
    (or (zero? amount) (zero? coin)) 1
    :else (+
            (change-count-recursive (- amount (value-of coin)) coin)
            (change-count-recursive amount (dec coin)))))


(defn replace-in-list [coll n x]
  (concat (take n coll) (list x) (nthnext coll (inc n))))

(defn change-count-iterative [amount coin]
  (defn product [combination]
    (reduce + (map * combination (rest values))))

  (defn overflowed? [combination]
    (> (count combination) coin))

  (defn shift [combination i]
    (def temp (replace-in-list combination i 0))
    (replace-in-list temp (inc i) (inc (nth temp (inc i)))))

  (defn next-comb [combination i]
    (replace-in-list combination i (inc (nth combination i))))

  (defn carry [combination i]
    (def comb (next-comb combination i))
    (if (<= (product comb) amount)
      comb
      (recur (shift comb i) (inc i))))

  (defn count-carries [combination cnt]
    (if (overflowed? combination)
      cnt
      (recur (carry combination 0) (inc cnt))))

  (count-carries (repeat coin 0) 0))

(println "Recursive: " (change-count-recursive 100 4))
(println "Iterative: " (change-count-iterative 100 4))
