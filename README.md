# SalesTax
Coding Assignmnet for itemis
# Build
Für das Build habe ich Gradle verwendet. Ihr braucht nur das Projekt zu klonen. 
# Design
Hier habe ich das Strategy pattern für die Berechnung von dem Tax verwendet. Das lässt sich auch einfach argumentieren. Wir haben ja mehrere Strategies zur Berechnung dieses Tax
und mit dem Strategy pattern kann man immer das Projekt erweitern und neue Strategies hinzufügen. Für das Produkt habe ich ein Taxable interface erstellt. Wenn man ein Startegy pattern verwendet dann braucht man in dem Kontext eine Methode, die das Strategy executet. Mit der Methode _tax_ dieser Schnittselle _Taxable_ kann man mit guter Codequalität das Strat ausführen, da alle konkreten Produkts die Methode nicht implementieren sollen und damit vermeiden wir redudanten Code. Das auch kann dabei helfen, dem Nutzer keine Implementierungsdetail zu zeigen. Die Tax Methode wurde in dem abs. Klasse ausgeführt mit dem entsprechenden Strategy für jedes konkreten Produkt. 
Der Nutzer kann einfach die Methode product.tax() verwenden und das System macht den Rest. 
Darüber hinaus habe ich auch das **Factory Design pattern** in manchen Klassen verwendet, um die Objekt erzeugung klarer zu machen.
# Rceipt
Die Quittung wurde sowohl als Pdf erstellt als auch in der Konsole geprintet.

# Test
ich habe das _TDD_ so viel wie möglich verwendet, aber ich war auch mit meine Bachelorarbeit beschäftigt, da ich in der Kommenden Woche abgebe. 
Die Tests sind in dem entsprechenden Paket und habe ich das Taxen und Receipt (Teilweise) getestet. 

# Thanks

