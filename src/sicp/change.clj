(ns sicp.change)

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
