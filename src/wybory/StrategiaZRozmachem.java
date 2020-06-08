package wybory;

import java.util.Arrays;

public class StrategiaZRozmachem implements Strategia {
    @Override
    public boolean wykonajDzialanie(DzialaniaWKampanii[] dzialania, int budzet, Okreg[] okregi) {
        DzialaniaWKampanii dzialanie = null;
        Okreg okreg = null;
        int maks = 0;

        for (DzialaniaWKampanii d : dzialania) {
            for (Okreg o : okregi) {
                int koszt = d.koszt(o.getLiczbaWyborcow());
                if (koszt > maks && koszt <= budzet) {
                    maks = koszt;
                    dzialanie = d;
                    okreg = o;
                }
            }
        }
        if (dzialanie != null) {
            dzialanie.wykonaj(okreg);
            return true;
        }
        return false;
    }
}
