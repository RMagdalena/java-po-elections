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
        LinkedList<KandydaciPartiiDanegoOkregu> kandydaciZOkregu = this.okregWyborczy.getWszyscyKandydaciOkregu();
        super.oddajGlos(WybieraZPartii.wybierzKandydatowDanejPartii(kandydaciZOkregu, wybranaPartia));
    }

    @Override
    protected int numerKandydata(LinkedList<KandydaciPartiiDanegoOkregu> kandydaciPartii) {
        return numerKandydata - 1;
    }
}
