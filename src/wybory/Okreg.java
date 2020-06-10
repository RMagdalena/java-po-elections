package wybory;

import java.util.Collection;
import java.util.LinkedList;

public class Okreg {
    protected final int numer;

    protected int liczbaWyborcow;
    protected LinkedList<Wyborca> listaWyborcow;

    protected final int liczbaMandatow;
    protected LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu;

    protected WynikiGlosowania wynikiGlosowania;
    protected int[] przydzieloneMandaty;
    protected OkregScalony okregScalony;

    public Okreg(int numer) {
        this.numer = numer;
        this.liczbaWyborcow = 0;
        this.listaWyborcow = null;
        this.liczbaMandatow = liczbaWyborcow; // TODO /10 testy
        this.wszyscyKandydaciOkregu = null;

        this.wynikiGlosowania = null;
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

    public void setPrzydzieloneMandaty(int[] przydzieloneMandaty) {
        this.przydzieloneMandaty = przydzieloneMandaty;
    }

    public void setWszyscyKandydaciOkregu(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu) {
        this.wszyscyKandydaciOkregu = wszyscyKandydaciOkregu;
    }

    public void setListaWyborcow(LinkedList<Wyborca> listaWyborcow) {
        this.listaWyborcow = listaWyborcow;
        this.liczbaWyborcow = listaWyborcow.size();
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

    public StringBuilder wypisz(Partia[] partie) {
        StringBuilder wynik = new StringBuilder();
        if (okregScalony != null) {
            wynik.append(okregScalony.toString());
        }
        else {
            if (wszyscyKandydaciOkregu != null && listaWyborcow != null && wynikiGlosowania != null) {
                wynik.append("Okreg numer " + numer + ":\n"
                        + "__Kandydaci:\n");
                for (KandydaciPartiiDanegoOkregu kandydaciPartiiDanegoOkregu : wszyscyKandydaciOkregu) {
                    wynik.append("___" + kandydaciPartiiDanegoOkregu.wypisz());
                }
                wynik.append("__Wyborcy:\n");
                for (Wyborca wyborca : listaWyborcow) {
                    wynik.append("___" + wyborca.wypisz());
                }
                wynik.append("__Mandaty partii w okregu:\n" + wypiszMandatyZOkregu(partie));
            }
        }
        return wynik;
    }

    private StringBuilder wypiszMandatyZOkregu(Partia[] partie) {
        StringBuilder wynik = new StringBuilder();
        for (int i = 0; i < partie.length; i++) {
            if (partie[i] != null && przydzieloneMandaty != null) {
                wynik.append("___" + partie[i].getNazwaPartii() + " " + przydzieloneMandaty[i] + '\n');
            }
        }
        return wynik;
    }

    // WYBORY

    public void glosowanie() {
        for (Wyborca wyborca : listaWyborcow) {
            wyborca.oddajGlos(wszyscyKandydaciOkregu);
            wyborca.getKandydatNaKtoregoGlosuje().dodajGlosy();
            wyborca.getKandydatNaKtoregoGlosuje().getPartia().dodajGlosy();
        }
    }

    public WynikiGlosowania liczenieGlosow(Partia[] partie) {
        int[] glosyNaPartie = new int[partie.length];

        // TODO

        WynikiGlosowania wynikiGlosowania = new WynikiGlosowania(partie, glosyNaPartie);
        return wynikiGlosowania;
    }

    public void setWynikiGlosowania(WynikiGlosowania wynikiGlosowania) { // TODO do testow
        this.wynikiGlosowania = wynikiGlosowania;
    }
}
