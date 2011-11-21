(ns sicp.change
  (:use [clojure.set]))

(defn change-count [change coins]
  (letfn [(possible? []
            (zero?
              (loop [i (dec (count coins))
                     remainder change]
                (if (neg? i)
                  remainder
                  (recur (dec i) (rem remainder (nth coins i)))))))

          (count-combinations []
            (loop [i (dec (count coins))
                   combs 0]
              (if (<= i 0)
                (inc combs)
                (recur (dec i) (+ combs (quot change (nth coins i)))))))

          (combinable? []
            (and (pos? change) (possible?)))]

    (if (combinable?) (count-combinations) 0)))

(defn first-denomination [kinds-of-coins]
  (cond
    (= kinds-of-coins 1) 1
    (= kinds-of-coins 2) 5
    (= kinds-of-coins 3) 10
    (= kinds-of-coins 4) 25
    (= kinds-of-coins 5) 50
    :else 0))

(defn cc [amount kinds-of-coins]
  (cond
    (= amount 0) 1
    (or (neg? amount) (zero? kinds-of-coins)) 0
    :else (+
            (cc amount (dec kinds-of-coins))
            (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))

;(defn counter-matrix [])

(defn multiples [amount coin]
  (letfn [(dec-coin [value]
            (- value coin))]
    (set (filter pos? (take amount (iterate dec-coin amount))))))

(defn count-matrix [amount coins]
  (def base (multiples amount (nth coins 0)))
  (letfn [(foo [coin]
            (count (intersection base (multiples amount coin))))]
    (reduce + (map foo (rest coins)))))


(def base (multiples 39 25))
(defn bar [coin]
  (count (intersection base (multiples 39 coin))))

;(print (bar 25))

;(print (multiples 39 50))

(def amount 39)
(println "calculated" (count-matrix amount [1 5 10 25 50]))
(print "should be" (cc amount 5))
