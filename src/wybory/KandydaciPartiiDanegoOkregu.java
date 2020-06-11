package wybory;

public class KandydaciPartiiDanegoOkregu {
    private final Partia partia;

    private final Kandydat[] kandydaciPartii;

    public KandydaciPartiiDanegoOkregu(Partia partia, Kandydat[] kandydaciPartii) {
        this.partia = partia;
        this.kandydaciPartii = kandydaciPartii;
    }

    public Partia getPartia() {
        return partia;
    }

    public Kandydat[] getKandydaciPartii() {
        return kandydaciPartii;
    }

    public StringBuilder wypisz() {
        StringBuilder wynik = new StringBuilder();
        for (Kandydat kandydat : kandydaciPartii) {
            wynik.append(kandydat.wypisz());
        }
        return wynik;
    }
}
