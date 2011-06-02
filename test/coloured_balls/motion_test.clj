(ns coloured-balls.motion-test
	(:use 
    coloured-balls.motion
		midje.sweet))
		
(fact "moving upwards - heading 0" (:pos (move-ball {:pos {:x 0 :y 0} :heading 0 :velocity 5})) => {:x 0 :y -5})

(fact "moving right - heading 90" (:pos (move-ball {:pos {:x 0 :y 0} :heading 270 :velocity 5})) => {:x 5 :y 0})
