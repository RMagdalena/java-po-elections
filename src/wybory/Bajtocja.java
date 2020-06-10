package wybory;

import java.util.LinkedList;
import java.util.Random;

public class Bajtocja {

    public void przeprowadzWybory(Okreg[] okregi, Partia[] partie, DzialaniaWKampanii[] dzialaniaWKampanii, Metoda metoda) {

        kampaniaWyborcza(okregi, partie, dzialaniaWKampanii);

        glosowanie(okregi);

        WynikiGlosowania wynikiGlosowania = liczenieGlosow(okregi, partie);

        rozdanieMandatow(okregi, partie, metoda);

        wypiszPosumowanie(okregi, partie, metoda);
    }


    private void kampaniaWyborcza(Okreg[] okregi, Partia[] partie, DzialaniaWKampanii[] dzialaniaWKampanii) {
        for (Partia partia : partie) {
            if (partia != null) {
                partia.kampania(okregi, dzialaniaWKampanii);
            }
        }
    }

    private void glosowanie(Okreg[] okregi) {
        for (Okreg okreg : okregi) {
            if (okreg != null) {
                if (okreg.getOkregScalony() != null) {
                    okreg.getOkregScalony().glosowanie();
                }
                else {
                    okreg.glosowanie();
                }
            }
        }
    }

    private WynikiGlosowania liczenieGlosow(Okreg[] okregi, Partia[] partie) {

        for (Okreg okreg : okregi) {
            if (okreg != null) {
                okreg.liczenieGlosow(partie);
            }
        }
        return null; // TODO
    }

    private void rozdanieMandatow(Okreg[] okregi, Partia[] partie, Metoda metoda) {
        for (Okreg okreg : okregi) {
            Okreg aktualnyOkreg = okreg;
            if (okreg != null) {
                if (aktualnyOkreg.getOkregScalony() != null) {
                    aktualnyOkreg = aktualnyOkreg.getOkregScalony();
                }
                int[] podzialMandatow = metoda.rozdajMandatyWOkregu(aktualnyOkreg.wynikiGlosowania, aktualnyOkreg.liczbaMandatow);
                aktualnyOkreg.setPrzydzieloneMandaty(podzialMandatow);
                for (int i = 0; i < partie.length; i++) {
                    partie[i].dodajMandaty(podzialMandatow[i]);
                }
            }
        }
    }

    public void wypiszPosumowanie(Okreg[] okregi, Partia[] partie, Metoda metoda) { // TODO public bo testy
        StringBuilder wynik = new StringBuilder();
        wynik.append(metoda.toString());
        wynik.append("Okregi:\n");
        if (okregi != null) {
            for (Okreg okreg : okregi) {
                wynik.append("_" + okreg.wypisz(partie) + "\n");
            }
        }
        wynik.append("Mandaty partii w skali kraju:\n");
        if (partie != null) {
            for (Partia partia : partie) {
                wynik.append("_" + partia.wypiszMandaty() + "\n");
            }
        }
        System.out.println(wynik);
    }
}

