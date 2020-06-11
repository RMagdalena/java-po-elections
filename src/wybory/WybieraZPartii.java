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
        if (wybrane.size() == 1) {
            return wybrane;
        }
        else if (wybrane.size() == 2) {
            Kandydat[] lista1 = wybrane.get(0).getKandydaciPartii();
            Kandydat[] lista2 = wybrane.get(1).getKandydaciPartii();
            Kandydat[] dodane = new Kandydat[lista1.length + lista2.length];
            for (int i = 0; i < lista1.length; i++) {
                dodane[i] = lista1[i];
            }
            for (int j = 0; j < lista2.length; j++) {
                dodane[lista1.length + j] = lista2[j];
            }
            KandydaciPartiiDanegoOkregu wynik = new KandydaciPartiiDanegoOkregu(wybranaPartia, dodane);

            LinkedList<KandydaciPartiiDanegoOkregu> wynikowaLista = new LinkedList<>();
            wynikowaLista.add(wynik);
            return wynikowaLista;
        }
        else {
            return null;
        }
    }
}
