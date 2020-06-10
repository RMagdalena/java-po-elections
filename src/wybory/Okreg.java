package wybory;

import java.util.LinkedList;

public class Okreg {
    protected final int numer;

    protected int liczbaWyborcow;
    protected LinkedList<Wyborca> listaWyborcow;

    protected int liczbaMandatow;
    protected LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu;

    protected WynikiGlosowania wynikiGlosowania;
    protected int[] przydzieloneMandaty;
    protected OkregScalony okregScalony;

    public Okreg(int numer) {
        this.numer = numer;
        this.liczbaWyborcow = 0;
        this.listaWyborcow = null;
        this.liczbaMandatow = liczbaWyborcow / 10;
        this.wszyscyKandydaciOkregu = null;

        this.wynikiGlosowania = null;
        this.przydzieloneMandaty = null;
        this.okregScalony = null;
    }

    public int getLiczbaWyborcow() {
        return liczbaWyborcow;
    }

    public void setLiczbaWyborcow(int liczbaWyborcow) {
        this.liczbaWyborcow = liczbaWyborcow;
    }

    public void setLiczbaMandatow(int liczbaMandatow) {
        this.liczbaMandatow = liczbaMandatow;
    }

    public int getLiczbaMandatow() {
        return liczbaMandatow;
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

    protected int getNumer() {
        return numer;
    }

    public void setOkregScalony(OkregScalony okregScalony) {
        this.okregScalony = okregScalony;
    }

    public void setPrzydzieloneMandaty(int[] przydzieloneMandaty) {
        this.przydzieloneMandaty = przydzieloneMandaty;
    }

    public void setWszyscyKandydaciOkregu(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu) {
        this.wszyscyKandydaciOkregu = wszyscyKandydaciOkregu;
    }

    public void setListaWyborcow(LinkedList<Wyborca> listaWyborcow) {
        this.listaWyborcow = listaWyborcow;
    }

    public void scalZOkregiem(Okreg okreg2) {

        int nowyNumer = this.numer;

        LinkedList<Wyborca> nowaListaWyborcow = new LinkedList<>();
        nowaListaWyborcow.addAll(this.listaWyborcow);
        nowaListaWyborcow.addAll(okreg2.listaWyborcow);

        LinkedList<KandydaciPartiiDanegoOkregu> nowiWszyscyKandydaciOkregu = new LinkedList<>();
        nowiWszyscyKandydaciOkregu.addAll(this.wszyscyKandydaciOkregu);
        nowiWszyscyKandydaciOkregu.addAll(okreg2.wszyscyKandydaciOkregu);

        OkregScalony okregScalony = new OkregScalony(nowyNumer, nowaListaWyborcow, nowiWszyscyKandydaciOkregu, this, okreg2);

        this.okregScalony = okregScalony;
        okreg2.setOkregScalony(this.okregScalony);
    }


    // WYBORY

    public void glosowanie() {
        for (Wyborca wyborca : listaWyborcow) {
            wyborca.oddajGlos(wszyscyKandydaciOkregu);
            wyborca.getKandydatNaKtoregoGlosuje().dodajGlosy();
            wyborca.getKandydatNaKtoregoGlosuje().getPartia().dodajGlosy();
        }
    }

    public void liczenieGlosow(Partia[] partie) {
        int[] glosyNaPartie = new int[partie.length];

        for (int i = 0; i < partie.length; i++) {
            glosyNaPartie[i] = partie[i].getUzyskaneGlosy();
        }
        this.wynikiGlosowania = new WynikiGlosowania(partie, glosyNaPartie);
    }

    public StringBuilder wypisz(Partia[] partie) {
        StringBuilder wynik = new StringBuilder();
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
}
