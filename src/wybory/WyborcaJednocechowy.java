package wybory;

import java.util.LinkedList;

public class WyborcaJednocechowy extends Wyborca {

    protected int cecha;
    protected final boolean minimalizuje; // Justyna C 1 3 1 // I N numerOkregu typWyborcy numerCechy
    protected final boolean maksymalizuje; // Konrad T 1 4 4

    public WyborcaJednocechowy(String imie, String nazwisko, Okreg okreg, int cecha, boolean minimalizuje, boolean maksymalizuje) {
        super(imie, nazwisko, okreg);
        this.cecha = cecha;
        this.minimalizuje = minimalizuje;
        this.maksymalizuje = maksymalizuje;
    }


    @Override
    protected LinkedList<Kandydat> stworzListeWybranych(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        LinkedList<Kandydat> listaWybranych = new LinkedList<>();

        int najlepszaWartosc = najlepszaWartoscCechy(wszyscyKandydaci);

        for (KandydaciPartiiDanegoOkregu partia : wszyscyKandydaci) {
            for (Kandydat k : partia.getKandydaciPartii()) {
                int wartoscCechy = k.getCechyKandydata()[cecha];
                if (wartoscCechy == najlepszaWartosc) {
                    listaWybranych.add(k);
                }
            }
        }
        return listaWybranych;
    }


    protected int najlepszaWartoscCechy(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        int min = Integer.MAX_VALUE;
        int maks = Integer.MIN_VALUE;
        for (KandydaciPartiiDanegoOkregu partia : wszyscyKandydaci) {
            for (Kandydat k : partia.getKandydaciPartii()) {
                int wartoscCechy = k.getCechyKandydata()[cecha];
                if (maksymalizuje) {
                    if (wartoscCechy > maks) {
                        maks = wartoscCechy;
                    }
                    else if (minimalizuje) {
                        if (wartoscCechy < min) {
                            min = wartoscCechy;
                        }
                    }
                }
            }
        }
        if (maksymalizuje) {
            return maks;
        }
        else {
            return min;
        }
    }
}
