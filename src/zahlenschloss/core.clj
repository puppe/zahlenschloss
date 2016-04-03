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

(ns zahlenschloss.core
  (:gen-class))

(defn teilbar?
  "Gibt `true` zurück, genau dann wenn `n` durch `x` teilbar ist."
  [x n]
  (= 0 (mod n x)))

(doseq [x [4 7 11]]
  (intern *ns*
          (symbol (str "teilbar" x "?"))
          (partial teilbar? x)))


(defn ziffern
  "Nimmt eine Zahl `n` und gibt die Folge der Ziffern der Zahl zurück."
  [n]
  (loop [n n
         ziffern (list)]
    (if (= n 0)
      ziffern
      (recur (int (/ n 10)) (conj ziffern (mod n 10))))))

; http://stackoverflow.com/a/5058544
(defn- exp [x n]
  "Berechnet x hoch n."
  (reduce * (repeat n x)))

(defn wert
  "Nimmt eine Folge von Ziffern und berechnet ihren Zahlenwert."
  [ziffern]
  (loop [summe 0
         faktor (exp 10 (dec (count ziffern)))
         [ziffer & ziffern] ziffern]
    (if ziffer
      (recur
        (+ summe (* ziffer faktor))
        (/ faktor 10)
        ziffern)
      summe)))

(defn links-auffüllen
  "Nimmt eine Folge von Ziffern und füllt sie, falls nötig, links mit
  Nullen auf, sodass das Ergebnis aus mindestens sechs Ziffern besteht."
  [ziffern]
  (loop [länge (count ziffern)
         ziffern ziffern]
    (if (>= länge 6)
      ziffern
      (recur
        (inc länge)
        (conj ziffern 0)))))

(defn rückwärts
  "Nimmt eine Zahl und dreht die Folge ihrer Ziffern um. Dabei wird
  angenommen, dass die Zahl mindestens sechsstellig ist. Das Ergebnis
  ist daher mindestens auch sechsstellig."
  [n]
  (wert (reverse (links-auffüllen (ziffern n)))))

(defn quersumme
  "Berechnet die Quersumme der Zahl `n`."
  [n]
  (apply + (ziffern n)))

(defn zähle-ziffern
  "Zählt, wie oft die einzelnen Ziffern in der Zahl `n` vorkommen. Es
  wird angenommen, dass `n` mindestens sechsstellig ist."
  [n]
  (reduce
    (fn [m ziffer]
      (assoc m ziffer (inc (get m ziffer 0))))
    {}
    (links-auffüllen (ziffern n))))

(defn doppelt-oder-gar-nicht?
  "Gibt `true` zurück, genau dann wenn jede Ziffer in der Zahl doppelt
  oder gar nicht vorkommt. Es wird angenommen, dass `n` mindestens
  sechsstellig ist."
  [n]
  (if (some #(not= % 2) (vals (zähle-ziffern n)))
    false
    true))

(defn -main
  [& args]
  (println "Mögliche Lösung(en):")
  (apply
    println
    (->> (range 0 1000000)
         ; Die Zahl ist durch 4 teilbar.
         (filter teilbar4?)
         ; Die Zahl ist rückwärts ebenfalls durch 4 teilbar.
         (filter #(teilbar4? (rückwärts %)))
         ; Die Zahl ist durch 7 teilbar.
         (filter teilbar7?)
         ; Die Zahl ist nicht durch 11 teilbar.
         (filter (complement teilbar11?))
         ; Die Quersumme der Zahl beträgt 32.
         (filter #(= 32 (quersumme %)))
         ; Jede Ziffer kommt entweder doppelt oder gar nicht vor.
         (filter doppelt-oder-gar-nicht?)
         ; Wir geben maximal 10 Zahlen aus.
         (take 10))))
