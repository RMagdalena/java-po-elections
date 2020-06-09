package wybory;

import java.util.LinkedList;

public class OkregScalony extends Okreg {

    private final Okreg okreg1;
    private final Okreg okreg2;

    public OkregScalony(int numer, int liczbaWyborcow, LinkedList<Wyborca> listaWyborcow, int liczbaMandatow, LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu, Okreg okreg1, Okreg okreg2) {
        super(numer, liczbaWyborcow, listaWyborcow, liczbaMandatow, wszyscyKandydaciOkregu);
        this.okreg1 = okreg1;
        this.okreg2 = okreg2;
    }

    public Okreg getOkreg1() {
        return okreg1;
    }

    public Okreg getOkreg2() {
        return okreg2;
    }
}
