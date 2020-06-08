package wybory;

import java.util.LinkedList;
import java.util.Random;

public abstract class Wyborca {
    protected final String imie;
    protected final String nazwisko;
    protected final Okreg okregWyborczy;
    protected Okreg scalonyOkreg;

    protected Kandydat kandydatNaKtoregoGlosuje;

    public Wyborca(String imie, String nazwisko, Okreg okregWyborczy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.okregWyborczy = okregWyborczy;
        this.scalonyOkreg = okregWyborczy.getScalonyZOkregiem();
    }

    public void oddajGlos(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        if (scalonyOkreg == null) {
            LinkedList<Kandydat> listaKandydatowWybranych = stworzListeWybranych(wszyscyKandydaci);

            if (listaKandydatowWybranych.size() > 0) {
                int numer = losujNumerKandydata(listaKandydatowWybranych.size());
                kandydatNaKtoregoGlosuje = listaKandydatowWybranych.get(numer);
            }
        }
        else {
            okregiPolaczone(wszyscyKandydaci, scalonyOkreg);
        }
    }

    protected void okregiPolaczone(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci, Okreg scalonyOkreg) {

        LinkedList<Kandydat> kandydaciZOkreguPodsatawowego = stworzListeWybranych(wszyscyKandydaci);
        LinkedList<Kandydat> kandydaciZOkreguScalonego = stworzListeWybranych(scalonyOkreg.getWszyscyKandydaciOkregu());
        int ileKandydatow = kandydaciZOkreguPodsatawowego.size() + kandydaciZOkreguScalonego.size();
        if (ileKandydatow > 0) {
            int numer = losujNumerKandydata(ileKandydatow);
            if (numer < kandydaciZOkreguPodsatawowego.size()) {
                kandydatNaKtoregoGlosuje = kandydaciZOkreguPodsatawowego.get(numer);
            }
            else {
                kandydatNaKtoregoGlosuje = kandydaciZOkreguScalonego.get(numer - kandydaciZOkreguPodsatawowego.size());
            }
        }

    }

    abstract protected LinkedList<Kandydat> stworzListeWybranych(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci);

    protected int losujNumerKandydata(int przedzial) {
        Random r = new Random();
        return r.nextInt(przedzial);
    }

    abstract public void zmienWagi(int[] opis);
}
