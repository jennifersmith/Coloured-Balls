(ns coloured-balls.position
  (:gen-class))

(defrecord Box [topleft bottomright])
(defrecord Point [x y])

(defmulti transpose (fn [item transposition] (class item)))
(defmethod transpose Point [pos transposition]
  (merge-with + pos transposition)
)
(defmethod transpose Box, Point [box transposition]
  (let [
         transpose-point (fn [point] (transpose point transposition))
          top-left (:topleft box)
          bottom-right (:bottomright box)
        ]
    (Box. (transpose-point top-left) (transpose-point bottom-right))

  )
  )
                                 

(defn get-box [ball]
  (let 
    [ centre  (:pos ball)
      radius (:radius ball)
      neg-radius (- 0 radius)
      box-zero (Box. (Point. neg-radius neg-radius) (Point. radius radius))
     ]
    (transpose box-zero centre)
  )
)

