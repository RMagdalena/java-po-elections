package wybory;

import java.util.LinkedList;

public class OkregScalony extends Okreg {

    private final Okreg okreg1;
    private final Okreg okreg2;

    public OkregScalony(int numer, LinkedList<Wyborca> listaWyborcow, LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu, Okreg okreg1, Okreg okreg2) {
        super(numer);
        this.okreg1 = okreg1;
        this.okreg2 = okreg2;
        this.wszyscyKandydaciOkregu = wszyscyKandydaciOkregu;
        this.listaWyborcow = listaWyborcow;
        this.liczbaWyborcow = listaWyborcow.size();
        this.liczbaMandatow = liczbaWyborcow / 10;
    }

    public Okreg getOkreg1() {
        return okreg1;
    }

    public Okreg getOkreg2() {
        return okreg2;
    }

    @Override
    public StringBuilder wypisz(Partia[] partie) {
        StringBuilder wynik = new StringBuilder();
        if (wszyscyKandydaciOkregu != null && listaWyborcow != null && wynikiGlosowania != null) {
            wynik.append(okreg1.getNumer() + " " + okreg2.getNumer() + "\n");
            for (KandydaciPartiiDanegoOkregu kandydaciPartiiDanegoOkregu : wszyscyKandydaciOkregu) {
                wynik.append(kandydaciPartiiDanegoOkregu.wypisz());
            }
            for (Wyborca wyborca : listaWyborcow) {
                wynik.append(wyborca.wypisz());
            }
            wynik.append("\n" + wypiszMandatyZOkregu(partie));
        }
        return wynik;
    }

    private StringBuilder wypiszMandatyZOkregu(Partia[] partie) {
        StringBuilder wynik = new StringBuilder();
        for (int i = 0; i < partie.length; i++) {
            if (partie[i] != null && przydzieloneMandaty != null) {
                wynik.append(partie[i].getNazwaPartii() + " " + przydzieloneMandaty[i] + '\n');
            }
        }
        return wynik;
    }
}
