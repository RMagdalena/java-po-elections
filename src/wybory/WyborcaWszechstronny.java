package wybory;

import java.util.LinkedList;

public class WyborcaWszechstronny extends Wyborca {

    // Krzysztof L 1 5 wagi: 58 86 69 -2 14 47 -35

    protected int[] wagiCech;

    public WyborcaWszechstronny(String imie, String nazwisko, Okreg okreg, int[] wagiCech) {
        super(imie, nazwisko, okreg);
        this.wagiCech = wagiCech;
    }

    @Override
    public int[] getWagiCech() {
        return wagiCech;
    }

    protected LinkedList<Kandydat> stworzListeWybranych(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        LinkedList<Kandydat> listaKandydatowWybranych = new LinkedList<>();
        int maksymalnaSuma = maksymalnaSumaWazona(wszyscyKandydaci);
        for (KandydaciPartiiDanegoOkregu partie : wszyscyKandydaci) {
            for (Kandydat kandydat : partie.getKandydaciPartii()) {
                int aktualnaSumaWazona = sumaWazona(kandydat);
                if (aktualnaSumaWazona == maksymalnaSuma) {
                    listaKandydatowWybranych.add(kandydat);
                }
            }
        }
        return listaKandydatowWybranych;
    }

    @Override
    public void zmienWagi(int[] opis) {
        for (int i = 0; i < wagiCech.length; i++) {
            wagiCech[i] += opis[i];
            wagiCech[i] = Math.max(-100, Math.min(100, wagiCech[i]));
        }
    }

    protected int maksymalnaSumaWazona(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        int maksymalnaSumaWazona = Integer.MIN_VALUE;
        for (KandydaciPartiiDanegoOkregu partie : wszyscyKandydaci) {
            for (Kandydat kandydat : partie.getKandydaciPartii()) {
                int aktualnaSumaWazona = sumaWazona(kandydat);
                if (aktualnaSumaWazona > maksymalnaSumaWazona) {
                    maksymalnaSumaWazona = aktualnaSumaWazona;
                }
            }
        }
        return maksymalnaSumaWazona;
    }

    protected int sumaWazona(Kandydat kandydat) {
        int[] cechyKandydata = kandydat.getCechyKandydata();
        int suma = 0;
        for (int i = 0; i < wagiCech.length; i++) {
            suma += cechyKandydata[i] * wagiCech[i];
        }
        return suma;
    }
}
