(ns sicp.change
  (:use [clojure.set])
  (:use [clojure.repl]))

(def values '(1, 5, 10, 25, 50))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;              Recursive version                      ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn value-of [coin]
  (nth values coin))

(defn change-count-recursive [amount coin]
  (cond
    (neg? amount) 0
    (or (zero? amount) (zero? coin)) 1
    :else (+
            (change-count-recursive (- amount (value-of coin)) coin)
            (change-count-recursive amount (dec coin)))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;              Iterative version                      ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn change-count-iterative
  "This is the iterative version of the change-count function. It is a constant space
  algorithm, but what it essentially does is enumerate and count all valid combinations
  (those that add up to the amount taken as input). But this is not good enough,
  since currently it is taking much longer than the recursive version to compute the same
  input."
  [amount coin]
  (letfn [(replace-item [coll n x]
            (letfn [(repl [index item]
                      (if (= index n) x item))]
              (keep-indexed repl coll)))

          (shift [combination i]
            (def temp (replace-item combination i 0))
            (if (< i (dec (count combination)))
              (replace-item temp (inc i) (inc (nth temp (inc i))))
              (cons 1 temp)))

          (product [combination]
            (reduce + (map * combination (rest values))))

          (overflowed? [combination]
            (> (count combination) coin))

          (next-comb [combination i]
            (replace-item combination i (inc (nth combination i))))

          (carry [combination index]
            (loop [comb (next-comb combination index)
                   i index]
              (if (<= (product comb) amount)
                comb
                (recur (shift comb i) (inc i)))))

          (count-carries [combination cnt]
            (if (overflowed? combination)
              cnt
              (recur (carry combination 0) (inc cnt))))]
    (if (zero? amount)
      0
      (count-carries (repeat coin 0) 0))))

(println "Recursive: " (time (change-count-recursive 100 4)))
(println "Iterative: " (time (change-count-iterative 100 4)))
