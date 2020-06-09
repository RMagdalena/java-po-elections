package wybory;

import java.util.Arrays;
import java.util.LinkedList;

public class StrategiaZachlanna implements Strategia {

    @Override
    public boolean wykonajDzialanie(DzialaniaWKampanii[] dzialania, int budzet, Okreg[] okregi, Partia partiaZlecajaca) {
        DzialaniaWKampanii najlepszeDzialanie = null;
        Okreg najlepszyOkreg = null;
        int najwiekszyWynik = Integer.MIN_VALUE;

        for (Okreg okreg : okregi) {

            Okreg aktualnyOkreg = okreg;
            if (okreg.okregScalony != null) {
                aktualnyOkreg = okreg.okregScalony;
            }

            LinkedList<Wyborca> wyborcyZOkregu = aktualnyOkreg.getListaWyborcow();
            Kandydat[] kandydaciZOkregu = WybieraZPartii.wybierzKandydatowDanejPartii(aktualnyOkreg.getWszyscyKandydaciOkregu(), partiaZlecajaca).get(0).getKandydaciPartii();

            int sumaOryginalna = 0;
            int sumaAktualna = 0;

            int[] wynikiDzialan = new int[dzialania.length];

            for (Wyborca wyborca : wyborcyZOkregu) {
                int[] wagiOryginalne = wyborca.getWagiCech();
                if (wagiOryginalne != null) {

                    for (Kandydat kandydat : kandydaciZOkregu) {
                        sumaOryginalna += sumaWazona(kandydat, wagiOryginalne);
                    }

                    // KOLEJNE DZIALANIA
                    int i = 0;
                    for (DzialaniaWKampanii d : dzialania) {
                        int[] wagiKopia = kopiujWagi(wagiOryginalne);
                        zmienWagi(d.getOpis(), wagiKopia);

                        // SUMY PO ZADZIALANIU DZIALANIEM
                        for (Kandydat kandydat : kandydaciZOkregu) {
                            wynikiDzialan[i] += sumaWazona(kandydat, wagiKopia);
                        }
                        i++;
                    }
                }
            }
            int maks = Integer.MIN_VALUE;
            int numerDzialania = 0;
            for (int i = 0; i < wynikiDzialan.length; i++) {
                if (wynikiDzialan[i] > maks) {
                    sumaAktualna = wynikiDzialan[i];
                    numerDzialania = i;
                }
            }

            int aktualnyWynik = sumaOryginalna - sumaAktualna;
            if (aktualnyWynik > najwiekszyWynik) {
                najwiekszyWynik = aktualnyWynik;
                najlepszeDzialanie = dzialania[numerDzialania];
                najlepszyOkreg = aktualnyOkreg;
            }

        }
        return false;
    }


    private int[] kopiujWagi(int[] wagiOryginalne) {
        int[] wynik = new int[wagiOryginalne.length];
        for (int i = 0; i < wagiOryginalne.length; i++) {
            wynik[i] = wagiOryginalne[i];
        }
        return wynik;
    }

    public void zmienWagi(int[] opis, int[] wagiCech) {
        for (int i = 0; i < wagiCech.length; i++) {
            wagiCech[i] += opis[i];
            wagiCech[i] = Math.max(-100, Math.min(100, wagiCech[i]));
        }
    }

    protected int sumaWazona(Kandydat kandydat, int[] wagiCech) {
        int[] cechyKandydata = kandydat.getCechyKandydata();
        int suma = 0;
        for (int i = 0; i < wagiCech.length; i++) {
            suma += cechyKandydata[i] * wagiCech[i];
        }
        return suma;
    }
}
