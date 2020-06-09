package wybory;

import java.util.Arrays;
import java.util.Random;

public class Bajtocja {

    public void przeprowadzWybory(Okreg[] okregi, Partia[] partie, int liczbaCechKandydatow, DzialaniaWKampanii[] dzialaniaWKampanii) {

        Metoda metoda = losujMetode();

        kampaniaWyborcza(okregi, partie, liczbaCechKandydatow, dzialaniaWKampanii);

        glosowanie(okregi);

        rozdanieMandatow();


    }

    private Metoda losujMetode() {
        Metoda metoda = null;

        Random r = new Random();
        int x = r.nextInt(3);
        if (x == 0) {
            metoda = new MetodaDHondta();
        }
        else if (x == 1) {
            metoda = new MetodaSaintLague();
        }
        else {
            metoda = new MetodaHareaNiemeyera();
        }
        return metoda;
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
            if (okreg.getOkregScalony() != null) {
                okreg.getOkregScalony().glosowanie();
            }
            else {
                okreg.glosowanie();
            }
        }
    }

    private void rozdanieMandatow() {
    }

}

