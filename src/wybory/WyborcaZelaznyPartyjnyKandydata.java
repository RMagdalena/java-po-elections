package wybory;

import java.util.LinkedList;

public class WyborcaZelaznyPartyjnyKandydata extends WyborcaZelaznyPartyjny {

    // Marta D 1 2 PartiaA 16

    private final int numerKandydata;

    public WyborcaZelaznyPartyjnyKandydata(String imie, String nazwisko, Okreg okreg, Partia wybranaPartia, int numerKandydata) {
        super(imie, nazwisko, okreg, wybranaPartia);
        this.numerKandydata = numerKandydata;
    }

    @Override
    public void oddajGlos(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        super.oddajGlos(WybieraZPartii.wybierzKandydatowDanejPartii(wszyscyKandydaci, wybranaPartia));
    }

    @Override
    protected int numerKandydata(LinkedList<KandydaciPartiiDanegoOkregu> kandydaciPartii) {
        return numerKandydata;
    }

    @Override
    protected void okregiPolaczone(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci, Okreg scalonyOkreg) {
        LinkedList<Kandydat> listaKandydatowWybranych = stworzListeWybranych(wszyscyKandydaci);

        if (listaKandydatowWybranych.size() > 0) {
            int numer = losujNumerKandydata(listaKandydatowWybranych.size());
            kandydatNaKtoregoGlosuje = listaKandydatowWybranych.get(numer);
        }
    }
}
