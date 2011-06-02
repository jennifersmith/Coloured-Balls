(ns coloured-balls.trig-test
	(:use 
    coloured-balls.trig
		midje.sweet))
		
(fact (sin 0) => 0)
(fact (sin 90) => 1.0)
(fact (sin 270) => -1.0)
		
(fact (cos 0) => 1.0)
(fact (cos 180) => -1.0)
(fact (cos 360) => 1.0)


