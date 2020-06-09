package wybory;

import java.util.LinkedList;

public class Partia {
    private final String nazwaPartii;
    private final int budzet;
    private final Strategia strategiaPartii;

    private final LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciPartii;

    private int uzyskaneGlosy;
    private int uzyskaneMandaty;

    public Partia(String nazwaPartii, int budzet, Strategia strategiaPartii, LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciPartii) {
        this.nazwaPartii = nazwaPartii;
        this.budzet = budzet;
        this.strategiaPartii = strategiaPartii;
        this.wszyscyKandydaciPartii = wszyscyKandydaciPartii;
        this.uzyskaneGlosy = 0;
        this.uzyskaneMandaty = 0;
    }

    public void kampania(Okreg[] okregi, int liczbaCechKandydatow, DzialaniaWKampanii[] dzialaniaWKampanii) {
        boolean czyWykonanoDzialanie = true;
        while (czyWykonanoDzialanie) {
            czyWykonanoDzialanie = strategiaPartii.wykonajDzialanie(dzialaniaWKampanii, budzet, okregi, this);
        }
    }

    public void dodajGlosy() {
        uzyskaneGlosy++;
    }

    public void dodajMandaty(int uzyskaneMandaty) {
        this.uzyskaneMandaty += uzyskaneMandaty;
    }

}
