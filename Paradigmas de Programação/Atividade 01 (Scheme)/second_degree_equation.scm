(define a 1)
(define b -5)
(define c 6)

;; With Lambda

(define sub
(lambda (x y)
(- x y)))

(define sum
(lambda (x y)
(+ x y)))

(define square
(lambda (x)
(* x x)))

(define divide
(lambda (x y)
(/ x y)))

(define mult
(lambda (x y)
(* x y)))

(define mult_three_numbers
(lambda (a b c)
(* a b c)))

(define invert_signal
(lambda (x)
(* -1 x)))

(define delta
(lambda (a b c)
(sub (square b) (mult_three_numbers 4 a c))))

(define root_1
(lambda (a b c)
(divide (sum (invert_signal b) (delta a b c)) (mult 2 a) )))

(define root_2
(lambda (a b c)
(divide (sub (invert_signal b) (delta a b c)) (mult 2 a) )))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Without Lambda


;; (define (sub x y)
;; (- x y))

;; (define (sum x y)
;; (+ x y))

;; (define (square x)
;; (* x x))

;; (define (divide x y)
;; (/ x y))

;; (define (mult x y)
;; (* x y))

;; (define (mult_three_numbers a b c)
;; (* a b c))

;; (define (invert_signal x)
;; (* -1 x))

;; (define (delta a b c)
;; (sub (square b) (mult_three_numbers 4 a c)))

;; (define (root_1 a b c)
;; (divide (sum (invert_signal b) (delta a b c)) (mult 2 a) ))

;; (define (root_2 a b c)
;; (divide (sub (invert_signal b) (delta a b c)) (mult 2 a) ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(display "Delta is: ")
(display (delta a b c))
(display "\nFirst root is: ")
(display (root_1 a b c))
(display "\nSecond root is: ")
(display (root_2 a b c))