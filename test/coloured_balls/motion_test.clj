(ns coloured-balls.motion-test
	(:use 
    coloured-balls.motion
		midje.sweet))
		
(fact "moving upwards - heading 0" (:pos (move-ball {:pos {:x 0 :y 10} :heading 0 :velocity 5})) => {:x 0 :y 5})

(fact "moving right - heading 90" (:pos (move-ball {:pos {:x 10 :y 0} :heading 90 :velocity 5})) => {:x 5 :y 0})

(fact "detect edge comes to a stop if next move would go over edge - left"
      (:velocity (detect-edge 200 200 {:pos {:x 5 :y 20} :heading 90 :velocity 2 :radius 5 })) => 0 )

(fact "detect edge - right"
      (:velocity (detect-edge 200 200 {:pos {:x 194 :y 20} :heading 270 :velocity 2 :radius 5 })) => 0 )
