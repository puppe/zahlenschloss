# zahlenschloss

Siehe <https://mpuppe.de/blog/2016/04/03/knobeln-mit-clojure/>.

Gesucht wird die Kombination für ein Zahlenschloss. Das Zahlenschoss hat
sechs Ziffern. Die gesuchte Zahl muss die folgenden Bedingungen
erfüllen:

1. Die Zahl ist durch 4 teilbar.
2. Die Zahl ist rückwärts ebenfalls durch 4 teilbar.
3. Die Zahl ist durch 7 teilbar.
4. Die Zahl ist *nicht* durch 11 teilbar.
5. Die Quersumme der Zahl beträgt 32.
6. Jede Ziffer kommt in der Zahl entweder doppelt oder gar nicht vor.

Dieses Repository enthält ein Clojure-Programm, das die Lösung ausgibt.

Am einfachsten ist es, das Programm mit
[Leiningen](http://leiningen.org/) auszuführen. `lein run` spuckt die
Lösung aus, `lein test` lässt die Tests durchlaufen.

Copyright © 2016 Martin Puppe

Distributed under the GNU General Public License either version 3.0 or
(at your option) any later version.
