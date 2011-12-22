(ns sicp.test.exponentiation
  (:use [sicp.exponentiation])
  (:use [lazytest.describe]))

(def base 201)
(def exponent 117)
(def exp-result 297809617085655773219390957379959318563871465697313274513384587971354510410370845746451029454764918029681044452082922425853772477216911506509323293510890159854395589367213568773104853221925056565183619098621507470520399328981412002898039279376782968641699202569311463401)
(describe "Exponentiation"
  (it "calculates exp using naive iterative method"
    (= exp-result (exp-iter-naive base exponent 1)))
  (it "calculates exp using the stack based method"
    (= exp-result (exp-stack base exponent)))
  (it "calculates exp using the smart iterative method"
    (= exp-result (exp-smart base exponent))))


(def a 716232)
(def b 327427)
(describe "Multiplication"
  (it "calculates product using naive method"
    (= 234513695064 (multiply-naive a b)))
  (it "calculates product using smart method"
      (= 234513695064 (multiply a b))))