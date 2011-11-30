(ns sicp.change
  (:use [clojure.set]))

;(defn change-count [change coins]
;  (letfn [(possible? []
;            (zero?
;              (loop [i (dec (count coins))
;                     remainder change]
;                (if (neg? i)
;                  remainder
;                  (recur (dec i) (rem remainder (nth coins i)))))))
;
;          (count-combinations []
;            (loop [i (dec (count coins))
;                   combs 0]
;              (if (<= i 0)
;                (inc combs)
;                (recur (dec i) (+ combs (quot change (nth coins i)))))))
;
;          (combinable? []
;            (and (pos? change) (possible?)))]
;
;    (if (combinable?) (count-combinations) 0)))
;
;(defn first-denomination [kinds-of-coins]
;  (cond
;    (= kinds-of-coins 1) 1
;    (= kinds-of-coins 2) 5
;    (= kinds-of-coins 3) 10
;    (= kinds-of-coins 4) 25
;    (= kinds-of-coins 5) 50
;    :else 0))
;
;(defn cc [amount kinds-of-coins]
;  (cond
;    (= amount 0) 1
;    (or (neg? amount) (zero? kinds-of-coins)) 0
;    :else (+
;            (cc amount (dec kinds-of-coins))
;            (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))
;
;;(defn counter-matrix [])
;
;(defn multiples [amount coin]
;  (letfn [(dec-coin [value]
;            (- value coin))]
;    (filter pos? (take amount (iterate dec-coin (dec amount))))))
;
;(defstruct node :value :weight)
;
;(defn constant-weights [mults]
;  (map (fn [value] (struct node value 1))) mults)
;
;(defn ordered-weights [mults]
;  (def max (count mults))
;  (map
;    (fn [index] (struct node (nth mults index) (- max index)))
;    (range 0 (dec max))))
;
;(defn update-weights [base new-weights]
;  (map (fn [nd] (if ()))))
;
;(defn count-matrix [amount coins]
;  (loop [index 1
;         options (constant-weights (multiples amount coins))
;         combinations 0]
;    (if (or (>= index (count coins)) (empty? options))
;      combinations
;      (recur
;        (inc index)t
;        (ordered-weights (multiples (nth coins (inc index)) coins))
;        combinations)))
;  )
;
;
;(def base (multiples 39 25))
;(defn bar [coin]
;  (count (intersection base (multiples 39 coin))))
;
;;(print (bar 25))
;
;(print (multiples 39 1))
;
;;(def amount 29)
;;(println "calculated" (count-matrix amount [1 5 10 25 50]))
;;(print "should be" (cc amount 5))
