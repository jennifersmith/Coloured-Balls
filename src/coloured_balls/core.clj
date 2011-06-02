(ns coloured-balls.core
  (:use 
        [coloured-balls.motion]
        [rosado.processing]
        [rosado.processing.applet])
  (:gen-class))

(defmacro dbg[x] `(let [x# ~x] (println '~x "=" x#) x#))
;; here's a function which will be called by Processing's (PApplet)
;; draw method every frame. Place your code here. If you eval it
;; interactively, you can redefine it while the applet is running and
;; see effects immediately

(defn draw-ball [ball]
	(fill (:red ball) (:green ball) (:blue ball))
	(ellipse (:x ball) (:y ball) (:radius ball) (:radius ball)))

(defn make-random-ball []
	{:x (rand-int 400) :y (rand-int 400) :red (rand-int 256) :blue (rand-int 256) :green (rand-int 256) :radius (+ 1 (rand-int 70))})

(defn make-ball []
	{:x 200 :y 200 :red 250 :blue 150 :green 256 :radius 45 :vx 2 :vy 2})

 

(def no-balls 1)
(def ball-state (atom (take no-balls (repeatedly make-ball))))

(defn draw
  []
  (background 150)
  (swap! ball-state #(map move-ball  %))
	(doall (map draw-ball @ball-state))
  
  )

(defn setup []
  "Runs once."
  (smooth)
  (no-stroke)
  (background 150)
  (framerate 10))

;; Now we just need to define an applet:

(defapplet balls :title "Coloured balls"
  :setup setup :draw draw :size [400 400])


