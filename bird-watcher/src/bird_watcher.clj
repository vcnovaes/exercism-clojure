(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])

(defn get-last-idx [arr]
  (- (count arr) 1))
 

(defn today [birds]
  (get
   birds (get-last-idx birds)))



(defn inc-bird [birds]
  (assoc birds
         (get-last-idx birds)
         (+ (today birds) 1)))



(defn day-without-birds? [birds]
  (= (count (filter (fn [x] (= 0 x)) [birds])) 0))


(defn n-days-count [birds n]
  (let [idx (dec n)]
    ((fn sum-to-idx [arr idx]
       (if (= idx 0)
         (get arr idx)
         (+ (get arr idx) (sum-to-idx arr (dec idx)))))
     birds idx)))



(defn busy-days [birds])


(defn odd-week? [birds])
  
