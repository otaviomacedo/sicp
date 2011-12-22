(ns sicp.test.square
  (:use [sicp.square])
  (:use [lazytest.describe]))

(describe "Square rooot"
  (it "calculates for a large number"
    (= 1.5787289336175572E16 (raiz-quadrada 249238492842987342189723672364732.0)))
  (it "calculates for a small number"
    (= 1.0000219921856583E-45 (raiz-quadrada 1.0E-90))))
