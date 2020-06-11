package wybory;

import java.util.LinkedList;

public class WyborcaZelaznyPartyjny extends Wyborca {
    // Ewa T 1 1 PartiaB

    protected final Partia wybranaPartia;

    public WyborcaZelaznyPartyjny(String imie, String nazwisko, Okreg okreg, Partia wybranaPartia) {
        super(imie, nazwisko, okreg);
        this.wybranaPartia = wybranaPartia;
    }

    @Override
    public void oddajGlos(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        super.oddajGlos(WybieraZPartii.wybierzKandydatowDanejPartii(wszyscyKandydaci, wybranaPartia));
    }

    @Override
    protected LinkedList<Kandydat> stworzListeWybranych(LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaci) {
        LinkedList<KandydaciPartiiDanegoOkregu> listyKandydatow = WybieraZPartii.wybierzKandydatowDanejPartii(wszyscyKandydaci, wybranaPartia);

        int wylosowanyIndeks = indeksKandydata(listyKandydatow);

        if (wylosowanyIndeks < okregWyborczy.getLiczbaMandatow()) {
            Kandydat[] kandydaci = listyKandydatow.get(0).getKandydaciPartii();
            LinkedList<Kandydat> wybraniKandydaci = new LinkedList<>();
            for (Kandydat k : kandydaci) {
                if (k.getNumerNaLiscie() == wylosowanyIndeks + 1) {
                    wybraniKandydaci.add(k);
                    break;
                }
            }
            return wybraniKandydaci;
        }
        else {
            if (okregWyborczy.getOkregScalony().getOkreg1().getNumer() == okregWyborczy.getNumer()) {
                return stworzListeWybranych(okregWyborczy.getOkregScalony().getOkreg2().getWszyscyKandydaciOkregu());
            }
            else {
                return stworzListeWybranych(okregWyborczy.getOkregScalony().getOkreg1().getWszyscyKandydaciOkregu());
            }
        }
    }

    protected int indeksKandydata(LinkedList<KandydaciPartiiDanegoOkregu> kandydaciPartii) {
        return losujNumerKandydata(kandydaciPartii.get(0).getKandydaciPartii().length);
    }
}
