(ns sicp.hof)

(defn cube [n]
  (* n n n))

(defn sum-iter [term a next b acc]
  (if (> a b)
    acc
    (recur term (next a) next b (+ acc (term a)))))

(defn sum [term a next b]
  (sum-iter term a next b 0))

(defn integral [f a b dx]
  (letfn [(add-dx [x] (+ x dx))]
    (* (sum f (+ a (/ dx 2.0)) add-dx b) dx)))

(defn product-iter [term a next b acc]
  (if (> a b)
    acc
    (recur term (next a) next b (*' acc (term a)))))

(defn product [term a next b]
  (product-iter term a next b 1))

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