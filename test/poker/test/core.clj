(ns poker.test.core
  (:use [poker.core])
  (:use [clojure.test]))

;;Test Data
(def pair-hand #{[:ace :clubs] [:two :diamonds] [:two :hearts]})
(def two-pair-hand #{[:ace :clubs] [:two :diamonds] [:two :hearts] [:ace :diamonds]})
(def three-of-a-kind-hand #{[:two :clubs] [:two :diamonds] [:two :hearts] [:ace :diamonds]})
(def four-of-a-kind-hand #{[:two :clubs] [:two :diamonds] [:two :hearts] [:two :spades]})
(def full-house-hand #{[:two :clubs] [:two :diamonds] [:king :hearts] [:king :spades] [:king :diamonds]})
(def flush-hand #{[:two :clubs] [:three :clubs] [:four :clubs] [:five :clubs] [:seven :clubs]})
(def straight-hand #{[:four :clubs] [:five :clubs] [:six :clubs] [:seven :clubs] [:eight :clubs]})
(def royal-flush-hand #{[:jack :clubs] [:ten :clubs] [:ace :clubs] [:king :clubs] [:queen :clubs]})

;;Helpers
(defn good-bad-test [hand-test good-hand bad-hand]
	(is (not (hand-test bad-hand)))
	(is (hand-test good-hand)))

;;Tests
(deftest value-test
	(is (= :ace (value [:ace :diamonds]))))

(deftest suit-test
	(is (= :diamonds (suit [:ace :diamonds]))))

(deftest value-lookup-test
	(is (= 2 (rank [:two :clubs])))
	(is (= 14 (rank [:ace :spades]))))

(deftest pair-test
	(good-bad-test pair? pair-hand two-pair-hand))

(deftest two-pair-test
	(good-bad-test two-pair? two-pair-hand pair-hand))

(deftest three-of-a-kind-test
	(good-bad-test three-of-a-kind? three-of-a-kind-hand two-pair-hand))

(deftest four-of-a-kind-test
	(good-bad-test four-of-a-kind? four-of-a-kind-hand two-pair-hand))

(deftest full-house-test
	(good-bad-test full-house? full-house-hand two-pair-hand))

(deftest flush-hand-test
	(good-bad-test flush? flush-hand full-house-hand))

(deftest straight-test
	(good-bad-test straight? straight-hand full-house-hand))

(deftest royal-flush-test
	(good-bad-test royal-flush? royal-flush-hand two-pair-hand))
