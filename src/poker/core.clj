(ns poker.core)

(def values '(:two :three :four :five :six :seven :eight :nine :ten :jack :queen :king :ace))
(def value-lookup (zipmap values (range 2 15)))

(defn value [card] (first card))
(defn suit [card] (last card))

(defn freq-map [hand chooser]
	(frequencies (map chooser hand)))

(defn values-map [hand]
	(frequencies (map value hand)))

(defn counts [size chooser hand] 
	(count (filter #(= size %) (vals (freq-map hand chooser)))))

(defn value-counts [size hand] 
	(counts size value hand))

(defn pairs [hand] 
	(value-counts 2 hand))

(defn pair? [hand]
	(= 1 (pairs hand)))

(defn two-pair? [hand]
	(= 2 (pairs hand)))

(defn three-of-a-kind? [hand]
	(= 1 (value-counts 3 hand)))

(defn four-of-a-kind? [hand]
	(= 1 (value-counts 4 hand)))

(defn full-house? [hand]
	(and (pair? hand) (three-of-a-kind? hand)))	

(defn flush? [hand]
	(= 1 (counts 5 suit hand)))