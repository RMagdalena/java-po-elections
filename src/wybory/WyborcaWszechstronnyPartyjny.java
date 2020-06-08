package wybory;

import java.util.LinkedList;

public class WyborcaWszechstronnyPartyjny extends WyborcaWszechstronny {

    // Jacek D 1 8 71 -25 72 -94 88 -73 34 PartiaA

    private final Partia wybranaPartia;

    public WyborcaWszechstronnyPartyjny(String imie, String nazwisko, Okreg okreg, int[] wagiCech, Partia wybranaPartia) {
        super(imie, nazwisko, okreg, wagiCech);
        this.wybranaPartia = wybranaPartia;
    }

    @Override
    public void oddajGlos(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        super.oddajGlos(WybieraZPartii.wybierzKandydatowDanejPartii(wszyscyKandydaci, wybranaPartia));
    }
}

