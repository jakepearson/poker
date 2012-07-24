(ns poker.test.core
  (:use [poker.core])
  (:use [clojure.test]))

(def pair-hand #{[:ace :clubs] [:two :diamonds] [:two :hearts]})
(def two-pair-hand #{[:ace :clubs] [:two :diamonds] [:two :hearts] [:ace :diamonds]})

(defn value [card] (first card))
(defn suit [card] (last card))
(defn freq-map [hand]
	(frequencies (map value hand)))

(defn counts [size hand] 
	(count (filter #(= size %) (vals (freq-map hand)))))

(defn pairs [hand] 
	(counts 2 hand))

(deftest value-test
	(is (= :ace (value [:ace :diamonds]))))

(deftest suit-test
	(is (= :diamonds (suit [:ace :diamonds]))))

(deftest freq-map-test
	(is (= {:ace 1, :two 2} (freq-map pair-hand))))

(deftest pair-test
	(is (= 1 (pairs pair-hand)))
	(is (= 2 (pairs two-pair-hand))))
