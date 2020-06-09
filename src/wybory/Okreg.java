package wybory;

import java.util.LinkedList;

public class Okreg {
    protected final int numer;

    protected final int liczbaWyborcow;
    protected final LinkedList<Wyborca> listaWyborcow;

    protected final int liczbaMandatow;
    protected final LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu;

    protected int[] przydzieloneMandaty;

//    protected Okreg scalonyZOkregiem;

    protected OkregScalony okregScalony;

    public Okreg(int numer, int liczbaWyborcow, LinkedList<Wyborca> listaWyborcow, int liczbaMandatow, LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu) {
        this.numer = numer;
        this.liczbaWyborcow = liczbaWyborcow;
        this.listaWyborcow = listaWyborcow;
        this.liczbaMandatow = liczbaMandatow;
        this.wszyscyKandydaciOkregu = wszyscyKandydaciOkregu;

        this.przydzieloneMandaty = null;

        this.okregScalony = null;
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

    public OkregScalony getOkregScalony() {
        return okregScalony;
    }

    public void scalZOkregiem(Okreg okreg2) {

        int nowyNumer = this.numer;
        int nowaLiczbaWyborcow = this.liczbaWyborcow + okreg2.liczbaWyborcow;

        LinkedList<Wyborca> nowaListaWyborcow = new LinkedList<>();
        nowaListaWyborcow.addAll(this.listaWyborcow);
        nowaListaWyborcow.addAll(okreg2.listaWyborcow);

        int nowaLiczbaMandatow = this.liczbaMandatow + okreg2.liczbaMandatow;

        LinkedList<KandydaciPartiiDanegoOkregu> nowiWszyscyKandydaciOkregu = new LinkedList<>();
        nowiWszyscyKandydaciOkregu.addAll(this.wszyscyKandydaciOkregu);
        nowiWszyscyKandydaciOkregu.addAll(okreg2.wszyscyKandydaciOkregu);

        OkregScalony okregScalony = new OkregScalony(nowyNumer, nowaLiczbaWyborcow, nowaListaWyborcow, nowaLiczbaMandatow, nowiWszyscyKandydaciOkregu, this, okreg2);

        this.okregScalony = okregScalony;
    }


    // WYBORY

    public void glosowanie() {
        for (Wyborca wyborca : listaWyborcow) {
            wyborca.oddajGlos(wszyscyKandydaciOkregu);
        }
    }

}
