; Copyright 2016 Martin Puppe

; This file is part of zahlenschloss.
;
; zahlenschloss is free software: you can redistribute it and/or modify
; it under the terms of the GNU General Public License as published by
; the Free Software Foundation, either version 3 of the License, or (at
; your option) any later version.
;
; zahlenschloss is distributed in the hope that it will be useful, but
; WITHOUT ANY WARRANTY; without even the implied warranty of
; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
; General Public License for more details.
;
; You should have received a copy of the GNU General Public License
; along with zahlenschloss. If not, see <http://www.gnu.org/licenses/>.

(ns zahlenschloss.core-test
  (:require [clojure.test :refer :all]
            [zahlenschloss.core :refer :all]))

(deftest teilbar?-test
  (is (teilbar? 4 16))
  (is (not (teilbar? 4 15))))

(deftest ziffern-test
  (is (= (seq (ziffern 123456)) (seq [1 2 3 4 5 6])))
  (is (= (seq (ziffern 0)) (seq []))))

(deftest wert-test
  (is (= (wert nil) 0))
  (is (= (wert '(1 2 3 4 5 6)) 123456)))

(deftest links-auffüllen-test
  (is (= (seq (links-auffüllen nil)) (seq [0 0 0 0 0 0])))
  (is (= (seq (links-auffüllen '(1))) (seq [0 0 0 0 0 1]))))

(deftest rückwärts-test
  (is (= (rückwärts 0) 0))
  (is (= (rückwärts 1) 100000))
  (is (= (rückwärts 123456) 654321)))

(deftest quersumme-test
  (is (= (quersumme 0) 0))
  (is (= (quersumme 123456) 21)))

(deftest zähle-ziffern-test
  (is (= (zähle-ziffern 0) {0 6}))
  (is (= (zähle-ziffern 933) {0 3, 9 1, 3 2})))

(deftest doppelt-oder-gar-nicht?-test
  (is (not (doppelt-oder-gar-nicht? 0)))
  (is (not (doppelt-oder-gar-nicht? 12345)))
  (is (doppelt-oder-gar-nicht? 234234)))
