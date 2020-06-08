package wybory;

import java.util.LinkedList;

public class Partia {
    private final int budzet;
    private final Strategia strategiaPartii;

    private final LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciPartii;

    public Partia(int budzet, Strategia strategiaPartii, LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciPartii) {
        this.budzet = budzet;
        this.strategiaPartii = strategiaPartii;
        this.wszyscyKandydaciPartii = wszyscyKandydaciPartii;
    }

    public void kampania(Okreg[] okregi, int liczbaCechKandydatow, DzialaniaWKampanii[] dzialaniaWKampanii) {
        boolean czyWykonanoDzialanie = true;
        while (czyWykonanoDzialanie) {
            czyWykonanoDzialanie = strategiaPartii.wykonajDzialanie(dzialaniaWKampanii, budzet, okregi);
        }
    }

}
