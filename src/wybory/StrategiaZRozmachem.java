package wybory;

public class StrategiaZRozmachem implements Strategia {
    @Override
    public boolean wykonajDzialanie(DzialaniaWKampanii[] dzialania, int budzet, Okreg[] okregi, Partia partiaZlecajaca) {
        DzialaniaWKampanii dzialanie = null;
        Okreg okreg = null;
        int maks = 0;

        for (DzialaniaWKampanii d : dzialania) {
            for (Okreg o : okregi) {
                Okreg aktualnyOkreg = o;
                if (o.okregScalony != null) {
                    if (o.getNumer() <= o.getOkregScalony().getNumer()) {
                        aktualnyOkreg = o.okregScalony;
                    }
                    else {
                        continue;
                    }
                }
                int koszt = d.koszt(o.getLiczbaWyborcow());
                if (koszt > maks && koszt <= budzet) {
                    maks = koszt;
                    dzialanie = d;
                    okreg = aktualnyOkreg;
                }
            }
        }
        if (dzialanie != null) {
            partiaZlecajaca.zaplacZaDzialanie(maks);
            dzialanie.wykonaj(okreg);
            return true;
        }
        return false;
    }
}
