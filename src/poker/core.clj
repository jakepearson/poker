(ns poker.core)

(defn value [card] (first card))
(defn suit [card] (last card))
(defn freq-map [hand]
	(frequencies (map value hand)))

(defn counts [size hand] 
	(count (filter #(= size %) (vals (freq-map hand)))))

(defn pairs [hand] 
	(counts 2 hand))

(defn pair? [hand]
	(= 1 (pairs hand)))

(defn two-pair? [hand]
	(= 2 (pairs hand)))

(defn three-of-a-kind? [hand]
	(= 1 (counts 3 hand)))

(defn four-of-a-kind? [hand]
	(= 1 (counts 4 hand)))

(defn full-house? [hand]
	(and (pair? hand) (three-of-a-kind? hand)))	