(ns sicp.hof
  (:use [sicp.primality]))

(defn cube [n]
  (* n n n))

(defn square [n] (* n n))

(defn accumulation [term a next b acc op]
  (if (> a b)
    acc
    (recur term (next a) next b (op acc (term a)) op)))

(defn sum [term a next b]
  (accumulation term a next b 0 +))

(defn integral [f a b dx]
  (letfn [(add-dx [x] (+ x dx))]
    (* (sum f (+ a (/ dx 2.0)) add-dx b) dx)))

(defn product [term a next b]
  (accumulation term a next b 1 *' ))

(defn simpsons-rule
  "Simpson's method for numerical function integration"
  [f a b n]
  (def h (/ (- a b) n))
  (letfn [(coefficient [i]
            (cond
              (or (= 0 i) (= n i)) 1
              (even? i) 2
              :else 4))
          (y [i]
            (f (+ a (* i h))))
          (simpson-term [i]
            (* (coefficient i) (y i)))]
    (* (/ h 3.0) (sum simpson-term 0 inc n))))

(defn factorial [n]
  (product identity 1 inc n))

(defn filtered-accumulate [term a next b acc op pred]
  (let [value (if (pred a) (op acc (term a)) acc)]
    (if (> a b)
      acc
      (recur term (next a) next b value op pred))))

(defn sum-of-squares-of-primes [a b]
  (filtered-accumulate square a inc b 0 + prime?))

(defn cont-frac-iter [n d k]
  (loop [i k res 0]
    (if (= 0 i)
      res
      (recur (dec i) (/ (n i) (+ (d i) res))))))

(defn cont-frac-recur [n d k i]
  (if (= k i)
    (/ (n i) (d i))
    (/ (n i) (+ (d i) (cont-frac-recur n d k (inc i))))))

(defn approximate-e []
  (cont-frac-iter
    (fn [i] 1.0)
    (fn [i] (if (zero? (rem (inc i) 3.0)) (* 2.0 (/ (inc i) 3.0)) 1.0))
    10))