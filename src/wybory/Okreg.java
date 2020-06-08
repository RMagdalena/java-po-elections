package wybory;

import java.util.LinkedList;

public class Okreg {
    private final int numer;

    private final int liczbaWyborcow;
    private final LinkedList<Wyborca> listaWyborcow;

    private final int liczbaMandatow;
    private final LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu;

    private int[] przydzieloneMandaty;

    private Okreg scalonyZOkregiem;

    public Okreg(int numer, int liczbaWyborcow, LinkedList<Wyborca> listaWyborcow, int liczbaMandatow, LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu) {
        this.numer = numer;
        this.liczbaWyborcow = liczbaWyborcow;
        this.listaWyborcow = listaWyborcow;
        this.liczbaMandatow = liczbaMandatow;
        this.wszyscyKandydaciOkregu = wszyscyKandydaciOkregu;

        this.przydzieloneMandaty = null;

        this.scalonyZOkregiem = null;
    }


    public int getLiczbaWyborcow() {
        return liczbaWyborcow;
    }

    public LinkedList<Wyborca> getListaWyborcow() {
        return listaWyborcow;
    }

    public LinkedList<KandydaciPartiiDanegoOkregu> getWszyscyKandydaciOkregu() {
        return wszyscyKandydaciOkregu;
    }

    public Okreg getScalonyZOkregiem() {
        return scalonyZOkregiem;
    }


    public void scalZOkregiem(Okreg drugiOkreg) {
        this.scalonyZOkregiem = drugiOkreg;
    }


    // WYBORY


    public void glosowanie() {
    }

}
