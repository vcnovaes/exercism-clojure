(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])


(defn today [birds]
  (last birds)
  )



(defn inc-bird [birds]
  (-> birds 
      pop 
      (conj (-> (last birds) inc))
      )
)

(defn day-without-birds? [birds]
  (-> birds
      (not-every? pos-int? birds)
      )
  )

(defn n-days-count [birds n]
  (let [idx (dec n)]
    ((fn sum-to-idx [arr idx]
       (if (= idx 0)
         (get arr idx)
         (+ (get arr idx) (sum-to-idx arr (dec idx)))))
     birds idx)))


(defn busy-days [birds]
  (count (filter (fn [n] (>= n 5)) 
          birds
          ))
  )

(defn odd-week? [birds] 
  ((fn is-odd [arr idx] 
    (if (= (- (count arr) 2) idx) 
      (if (= (get arr idx) 0 ) 
        (not= 0 (get arr (inc idx)))
        (not= 1 (get arr (inc idx)))
        )
      (if (= (get arr idx) 0 ) 
        (and (not= 0 (get arr (inc idx))) (is-odd arr (inc idx)))
        (and (not= 1 (get arr (inc idx))) (is-odd arr (inc idx)))
        )
      )) birds 0 
    )
  )
