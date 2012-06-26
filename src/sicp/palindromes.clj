(ns sicp.palindromes
  (:use (clojure.contrib)))

(defn convert-next-digit [quotient binary]
  (if (zero? quotient)
    (apply str (reverse binary))
    (recur (quot quotient 2) (str binary (rem quotient 2)))))

(defn to-binary [n]
  (convert-next-digit n ""))

;(defn palindrome? [s]
;  )
