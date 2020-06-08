package wybory;

import java.util.LinkedList;

public class WyborcaJednocechowyPartyjny extends WyborcaJednocechowy {

    // Pawel G 1 6 4 PartiaA
    // Jacek R 1 7 5 PartiaA

    private final Partia wybranaPartia;

    public WyborcaJednocechowyPartyjny(String imie, String nazwisko, Okreg okreg, int cecha, boolean minimalizuje, boolean maksymalizuje, Partia wybranaPartia) {
        super(imie, nazwisko, okreg, cecha, minimalizuje, maksymalizuje);

        this.wybranaPartia = wybranaPartia;
    }

    @Override
    public void oddajGlos(LinkedList<KandydaciPartiiDanegoOkregu> kandydaci) {
        super.oddajGlos(WybieraZPartii.wybierzKandydatowDanejPartii(kandydaci, wybranaPartia));
    }
}


