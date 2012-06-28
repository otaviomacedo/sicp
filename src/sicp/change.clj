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

;    private static int changeCoinsLinearSpace(int amount, int coin){
;        List<Integer> combination = newArrayList(Collections.nCopies(coin - 1, 0))
;
;        int result = 0;
;        while (carry(combination, amount)){
;            result++;
;        }
;        return result + 1;
;    }
;
;    private static boolean carry(List<Integer> combination, int amount){
;        int i = 0;
;        combination.set(i, combination.get(i) + 1);
;        while (overflow(combination, amount)){
;            combination.set(i, 0);
;            i++;
;            if (i > combination.size() - 1){
;                return false;
;            }
;            combination.set(i, combination.get(i) + 1);
;        }
;        return true;
;    }



(defn overflow [combination amount]
  (> (reduce + (map * combination (rest values))) amount))


(println "Resultado: " (change-count-recursive 100 4))
