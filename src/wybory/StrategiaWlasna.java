package wybory;

public class StrategiaWlasna extends StrategiaZRozmachem implements Strategia {

    // Wybieram dzialanie najdrozsze jednak z rozwagą, ponieważ tym razem ograniczeniem jest polowa danego budzetu,
    // jesli polowa budzetu nie wystarczy na zakup zadnego dzialnia, wybieram najdrozsze majac do dyspozycji caly budzet.

    public StrategiaWlasna() {
    }

    @Override
    public boolean wykonajDzialanie(DzialaniaWKampanii[] dzialania, int budzet, Okreg[] okregi, Partia partiaZlecajaca) {
        int polowaBudzetu = budzet / 2;

        boolean czyWystarczy = super.wykonajDzialanie(dzialania, polowaBudzetu, okregi, partiaZlecajaca);
        if (czyWystarczy) {
            return true;
        }
        else {
            return super.wykonajDzialanie(dzialania, budzet, okregi, partiaZlecajaca);
        }
    }
}
