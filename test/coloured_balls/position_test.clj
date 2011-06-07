(ns coloured-balls.position-test
	(:use 
    coloured-balls.position
		midje.sweet)
  (:import (coloured-balls.position Point Box)))
	
(fact (get-box {:pos (Point. 20 40 ) :radius 100 }) => (Box. (Point. -80 -60) (Point. 120 140)))

