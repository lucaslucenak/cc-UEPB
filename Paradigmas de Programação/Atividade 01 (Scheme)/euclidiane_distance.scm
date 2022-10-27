;; (sqrt (sum (square (sub ax ay)) (square (sub bx by))))

(define ax 33)
(define ay 3)
(define bx 3)
(define by 3)

;; With Lambda

(define sum
(lambda (x y)
(+ x y)))

(define sub
(lambda (x y)
(- x y)))

(define square
(lambda (x)
(* x x)))

(define eclidiane_distance
(lambda(ax ay bx by)
(sqrt (sum (square (sub ax ay)) (square (sub bx by))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Without Lambda

(define (sum x y)
(+ x y))

(define (sub x y)
(- x y))

(define (square x)
(* x x))

(define (eclidiane_distance ax ay bx by)
(sqrt (sum (square (sub ax ay)) (square (sub bx by)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(eclidiane_distance ax ay bx by)