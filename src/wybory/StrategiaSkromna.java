package wybory;

public class StrategiaSkromna implements Strategia {

    public boolean wykonajDzialanie(DzialaniaWKampanii[] dzialania, int budzet, Okreg[] okregi, Partia partiaZlecajaca) {
        Okreg okreg = znajdzNajmniejszyOkreg(okregi);
        if (okreg != null) {
            DzialaniaWKampanii dzialanie = najtanszeDzialanie(dzialania, okreg);

            if (dzialanie != null && dzialanie.koszt(okreg.getLiczbaWyborcow()) <= budzet) {
                dzialanie.wykonaj(okreg);
                return true;
            }
        }
        return false;
    }

    private DzialaniaWKampanii najtanszeDzialanie(DzialaniaWKampanii[] dzialaniaWKampanii, Okreg okreg) {
        DzialaniaWKampanii dzialanie = null;
        int min = Integer.MAX_VALUE;
        Okreg aktualnyOkreg = okreg;
        if (okreg.okregScalony != null) {
            aktualnyOkreg = okreg.okregScalony;
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
                aktualnyOkreg = okreg.okregScalony;
            }
            if (okreg.getLiczbaWyborcow() < najmniej) {
                wynik = okreg;
                najmniej = okreg.getLiczbaWyborcow();
            }

        }
        return wynik;
    }
}
