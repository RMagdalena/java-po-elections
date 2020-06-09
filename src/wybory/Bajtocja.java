package wybory;

import java.util.LinkedList;
import java.util.Random;

public class Bajtocja {

    public void przeprowadzWybory(Okreg[] okregi, Partia[] partie, int liczbaCechKandydatow, DzialaniaWKampanii[] dzialaniaWKampanii, Metoda metoda) {

        // TODO usunac liczbe cech kandydatow

        kampaniaWyborcza(okregi, partie, liczbaCechKandydatow, dzialaniaWKampanii);

        glosowanie(okregi);

        WynikiGlosowania wynikiGlosowania = liczenieGlosow(okregi, partie);

        rozdanieMandatow(okregi, partie, metoda);

        wypiszPosumowanie(okregi, partie, metoda);
    }


    private void kampaniaWyborcza(Okreg[] okregi, Partia[] partie, int liczbaCechKandydatow, DzialaniaWKampanii[] dzialaniaWKampanii) {
        for (Partia partia : partie) {
            if (partia != null) {
                partia.kampania(okregi, liczbaCechKandydatow, dzialaniaWKampanii);
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

    private void wypiszPosumowanie(Okreg[] okregi, Partia[] partie, Metoda metoda) {
        metoda.toString();
        for (Okreg okreg : okregi) {
            okreg.toString();
        }
        for (Partia partia : partie) {
            partia.toString();
        }
    }
}

