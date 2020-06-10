package wybory;

import java.util.LinkedList;

public class OkregScalony extends Okreg {

    private final Okreg okreg1;
    private final Okreg okreg2;
    private boolean wypisano;

    public OkregScalony(int numer, LinkedList<Wyborca> listaWyborcow, LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu, Okreg okreg1, Okreg okreg2) {
        super(numer);
        this.okreg1 = okreg1;
        this.okreg2 = okreg2;
        this.wszyscyKandydaciOkregu = wszyscyKandydaciOkregu; // TODO ??
        this.listaWyborcow = listaWyborcow;
        this.liczbaWyborcow = listaWyborcow.size();
        this.liczbaMandatow = liczbaWyborcow / 10; // TODO / 10 - test
        this.wypisano = false;
    }

    public Okreg getOkreg1() {
        return okreg1;
    }

    public Okreg getOkreg2() {
        return okreg2;
    }

    public StringBuilder wypisz(Partia[] partie) {
        StringBuilder wynik = new StringBuilder();
        if (!wypisano && wszyscyKandydaciOkregu != null && listaWyborcow != null && wynikiGlosowania != null) {
            wynik.append("Okreg scalony: numer " + okreg1.getNumer() + " oraz numer " + okreg2.getNumer() + ":\n"
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
        this.wypisano = !wypisano;
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
