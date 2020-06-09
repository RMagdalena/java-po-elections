package wybory;

public class StrategiaWlasna implements Strategia {

    @Override
    public boolean wykonajDzialanie(DzialaniaWKampanii[] dzialania, int budzet, Okreg[] okregi, Partia partiaZlecajaca) {
        return true;
    }
}
