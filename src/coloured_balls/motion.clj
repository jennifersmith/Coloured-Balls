(ns coloured-balls.motion
  (:use coloured-balls.trig  clojure.contrib.math)
  (:gen-class))

(defmacro dbg[x] `(let [x# ~x] (println '~x "=" x#) x#))

(defn get-new-pos [displacement heading pos]
  (assoc
    pos
    :y (+ (:y pos) (* -1 (round (* (cos heading) displacement))))
    :x (+ (:x pos) (* -1 (round (* (sin heading) displacement))))
  )
)

(defn move-ball [ball]
  (assoc
    ball
    :pos (get-new-pos (:velocity ball) (:heading ball) (:pos ball))
  )
)

(defn out-of-range [width height ball]
  (let
    [
     pos (:pos ball)
     left-edge  (- (:x pos) (:radius ball))
     right-edge  (+ (:x pos) (:radius ball))
    ]
      (> 0 left-edge)
  )
)

(defn detect-edge [width height ball]
  (if (out-of-range width height (move-ball ball))
   (assoc ball :velocity 0)
   ball
  )
  )
