package wybory;

import java.util.LinkedList;

public class WyborcaZelaznyPartyjny extends Wyborca {
    // Ewa T 1 1 PartiaB

    protected final Partia wybranaPartia;

    public WyborcaZelaznyPartyjny(String imie, String nazwisko, Okreg okreg, Partia wybranaPartia) {
        super(imie, nazwisko, okreg);
        this.wybranaPartia = wybranaPartia;
    }

    @Override
    public void oddajGlos(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {

        super.oddajGlos(WybieraZPartii.wybierzKandydatowDanejPartii(wszyscyKandydaci, wybranaPartia));
    }

    @Override
    protected LinkedList<Kandydat> stworzListeWybranych(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        LinkedList<KandydaciPartiiDanegoOkregu> kandydaci = WybieraZPartii.wybierzKandydatowDanejPartii(wszyscyKandydaci, wybranaPartia);
        int numerKandydata = numerKandydata(kandydaci);
        LinkedList<Kandydat> wybraniKandydaci = new LinkedList<>();
        for (Kandydat k : kandydaci.get(0).getKandydaciPartii()) {
            if (k.getNumerNaLiscie() == numerKandydata) {
                wybraniKandydaci.add(k);
            }
        }
        return wybraniKandydaci;
    }

    @Override
    public void zmienWagi(int[] opis) {
        // strategia nie ma wplywu na tego wyborce
    }

    protected int numerKandydata(LinkedList<KandydaciPartiiDanegoOkregu> kandydaciPartii) {
        return losujNumerKandydata(kandydaciPartii.get(0).getKandydaciPartii().length);
    }
}
