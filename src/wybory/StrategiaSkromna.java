package wybory;

public class StrategiaSkromna implements Strategia {

    public boolean wykonajDzialanie(DzialaniaWKampanii[] dzialania, int budzet, Okreg[] okregi, Partia partiaZlecajaca) {
        Okreg okreg = znajdzNajmniejszyOkreg(okregi);
        if (okreg != null) {
            DzialaniaWKampanii dzialanie = najtanszeDzialanie(dzialania, okreg);
            if (dzialanie != null) {
                int koszt = dzialanie.koszt(okreg.getLiczbaWyborcow());
                if (koszt <= budzet) {
                    dzialanie.wykonaj(okreg);
                    partiaZlecajaca.zaplacZaDzialanie(koszt);
                    return true;
                }
            }
        }
        return false;
    }

    private DzialaniaWKampanii najtanszeDzialanie(DzialaniaWKampanii[] dzialaniaWKampanii, Okreg okreg) {
        DzialaniaWKampanii dzialanie = null;
        int min = Integer.MAX_VALUE;
        Okreg aktualnyOkreg = okreg;
        if (okreg.okregScalony != null) {
            if (okreg.getNumer() <= okreg.getOkregScalony().getNumer()) {
                aktualnyOkreg = okreg.okregScalony;
            }
            else {
                return dzialanie;
            }
        }
        for (DzialaniaWKampanii d : dzialaniaWKampanii) {
            if (d.koszt(aktualnyOkreg.getLiczbaWyborcow()) < min) {
                dzialanie = d;
            }
        }
        return dzialanie;
    }

    private Okreg znajdzNajmniejszyOkreg(Okreg[] okregi) {
        Okreg wynik = null;
        int najmniej = Integer.MAX_VALUE;
        for (Okreg okreg : okregi) {
            Okreg aktualnyOkreg = okreg;
            if (okreg.okregScalony != null) {
                if (okreg.getNumer() < okreg.getOkregScalony().getNumer()) {
                    aktualnyOkreg = okreg.okregScalony;
                }
                else {
                    continue;
                }
            }
            if (aktualnyOkreg.getLiczbaWyborcow() < najmniej) {
                wynik = aktualnyOkreg;
                najmniej = aktualnyOkreg.getLiczbaWyborcow();
            }
        }
        return wynik;
    }
}
