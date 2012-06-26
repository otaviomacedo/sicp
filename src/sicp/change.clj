(ns sicp.change
  (:use [clojure.set]))

(def value (hash-map
         5, 50,
         4, 25,
         3, 10,
         2, 5,
         1, 1))

(defn rec-sum [fn amount coin i acc]
  (if (> i (/ amount (get value coin)))
    acc
    (fn (- amount (* i (get value coin))) (dec coin))))

(defn change-count [amount coin]
  (if ((or (= amount 0) (= coin 1)))
    1
    (rec-sum change-count amount coin 0 0)))


;private static int f(int a, int c, int level) {
;                                                if (a == 0 || c == 1) {
;                                                                        return 1;
;                                                                        }
;
;  int result = 0;
;  for (int i = 0; i <= a / V.get(c); i++) {
;        result +=  f(a - i*V.get(c), c -1, level + 1);
;        }
;
;        return result;
;        }
