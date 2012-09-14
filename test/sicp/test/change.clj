(ns sicp.test.change
  (:use [sicp.change])
  (:use [lazytest.describe]))

(describe "Money changer"

  (testing "Normal conditions"
    (it "changes 100c"
      (= 292 (change-count-iterative 100 4))))

  (testing "Exceptional conditions"
    (it "Zero cent"
      (= 0 (change-count-iterative 0 4)))
;    (it "Negative value"
;      (= 0 (change-count -999 normal-coins)))
;    (it "Impossible combination"
;      (= 0 (change-count 26 strange-coins))))
  )

;  (testing "Values under 5c"
;    (it "1 cent"
;      (= 1 (change-count 1 normal-coins)))
;    (it "4 cents"
;      (= 1 (change-count 4 normal-coins))))
;
;  (testing "Values >= 5c and < 10c"
;    (it "5 cents"
;      (= 2 (change-count 5 normal-coins )))
;    (it "9 cents"
;      (= 2 (change-count 9 normal-coins ))))
;
;  (testing "Values >= 10c and < 15c"
;    (it "10 cents"
;      (= 4 (change-count 10 normal-coins )))
;    (it "14 cents"
;      (= 4 (change-count 14 normal-coins ))))
;
;  (testing "Values >= 15c and < 20c"
;    (it "15 cents"
;      (= 5 (change-count 15 normal-coins )))
;    (it "19 cents"
;      (= 5 (change-count 19 normal-coins ))))
;
;  (testing "Values close to $1"
;    (it "98 cents"
;      (= 33 (change-count 98 normal-coins )))
;    (it "99 cents"
;      (= 33 (change-count 99 normal-coins ))))

  )
