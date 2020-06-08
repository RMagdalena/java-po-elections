package wybory;

import java.util.LinkedList;

public class WybieraZPartii {

    public static LinkedList<KandydaciPartiiDanegoOkregu> wybierzKandydatowDanejPartii(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci, Partia wybranaPartia) {
        LinkedList<KandydaciPartiiDanegoOkregu> wybrane = new LinkedList<>();
        for (KandydaciPartiiDanegoOkregu partia : wszyscyKandydaci) {
            if (partia.getPartia() == wybranaPartia) {
                wybrane.add(partia);
            }
        }
        return wybrane;
    }
}
