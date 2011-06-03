(ns coloured-balls.motion
  (:use coloured-balls.trig  clojure.contrib.math)
  (:gen-class))

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
