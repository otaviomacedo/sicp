(ns sicp.main
  (:use (clojure.contrib math)))

(defn new-if [predicate then-clause else-clause]
  (cond
    predicate then-clause
    :else else-clause))

(defn square [n]
  (* n n))

(defn cube [n]
  (* n (square n)))
