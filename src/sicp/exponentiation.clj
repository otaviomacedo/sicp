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

(defn square [n]
  (*' n n))

(defn apply-stack [base stack]
  (loop [s stack value 1]
    (if (empty? s)
      value
      (recur (rest s) ((first s) value)))))

(defn exp-stack [base exponent]
  (loop [e exponent stack (list)]
    (cond
      (zero? e) (apply-stack base stack)
      (even? e) (recur (/ e 2) (cons square stack))
      :else (recur (dec e) (cons (partial *' base) stack)))))


(defn exp-iter-naive [b counter product]
  (if (= counter 0)
    product
    (recur b
      (- counter 1)
      (*' b product))))

(defn exp-smart [base exponent]
  (loop [a 1 b base n exponent]
    (cond
      (zero? n) a
      (even? n) (recur a (square b) (/ n 2))
      :else (recur (*' a b) b (dec n)))))

(defn exp [base exponent]
  (exp-smart base exponent))


;(def base 19)
;(def exponent 104709)
;(println (time (exp-iter-naive base exponent 1)))
;(println (time (exp-stack base exponent )))
;(println (time (exp-smart base exponent )))
;
;(def a 388123712)
;(def b 316341672)
;(println (time (multiply a b)))
;(println (time (multiply-naive a b)))

;(println (rem (exp 10 17) 17))