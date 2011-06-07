(ns coloured-balls.core
  (:use 
        [coloured-balls.motion]
        [rosado.processing]
        [rosado.processing.applet])
  (:gen-class))

;; here's a function which will be called by Processing's (PApplet)
;; draw method every frame. Place your code here. If you eval it
;; interactively, you can redefine it while the applet is running and
;; see effects immediately

(defn animate [balls]
  (let
    [animate-ball (comp move-ball (partial detect-edge 400 400))]
    (map animate-ball balls)
  )
 )

(defn draw-ball [ball]
  (let [pos (:pos ball)
        width (* (:radius ball) 2)
        height width]
	(fill (:red ball) (:green ball) (:blue ball))
	(ellipse (:x pos) (:y pos) width height)
  ))
(defn make-random-ball []
	{:x (rand-int 400) :y (rand-int 400) :red (rand-int 256) :blue (rand-int 256) :green (rand-int 256) :radius (+ 1 (rand-int 70))})

(defn make-ball []
	{:pos {:x 200 :y 200} :heading 90 :red 250 :blue 150 :green 256 :radius 50 :velocity 2})


(def no-balls 1)
(def ball-state (atom (take no-balls (repeatedly make-ball))))

(defn draw
  []
  (background 150)
  (swap! ball-state animate)
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


