;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname abc) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp")) #f)))
(define (timestwo x) (* 2 x))

(timestwo 3)

(timestwo (timestwo 4))

(define (red-square s) (square s "solid" "red"))

(red-square 4)
(red-square 8)
(red-square 16)