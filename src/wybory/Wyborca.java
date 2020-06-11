package wybory;

import java.util.LinkedList;
import java.util.Random;

public abstract class Wyborca {
    protected final String imie;
    protected final String nazwisko;
    protected final Okreg okregWyborczy;
    protected Okreg scalonyZOkregiem;

    protected Kandydat kandydatNaKtoregoGlosuje;

    public Wyborca(String imie, String nazwisko, Okreg okregWyborczy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.okregWyborczy = okregWyborczy;
        this.scalonyZOkregiem = okregWyborczy.getOkregScalony();
    }

    public int[] getWagiCech() {
        // dziala tylko u wyborcow, ktorzy maja wagi cech
        return null;
    }

    public Kandydat getKandydatNaKtoregoGlosuje() {
        return kandydatNaKtoregoGlosuje;
    }

    public void zmienWagi(int[] opis) {
        // dziala tylko u wyborcow, ktorzy maja wagi cech
    }

    public void oddajGlos(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        LinkedList<Kandydat> listaKandydatowWybranych = stworzListeWybranych(wszyscyKandydaci);
        if (listaKandydatowWybranych.size() > 0) {
            int numer = losujNumerKandydata(listaKandydatowWybranych.size());
            kandydatNaKtoregoGlosuje = listaKandydatowWybranych.get(numer);
        }
    }

    abstract protected LinkedList<Kandydat> stworzListeWybranych(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci);

    protected int losujNumerKandydata(int przedzial) {
        Random r = new Random();
        return r.nextInt(przedzial);
    }

    public StringBuilder wypisz() {
        StringBuilder wynik = new StringBuilder();
        if (kandydatNaKtoregoGlosuje != null) {
            return wynik.append(imie + ' ' + nazwisko + ' ' + kandydatNaKtoregoGlosuje.wypiszImieNazwisko() + "\n");
        }
        return wynik;
    }
}
