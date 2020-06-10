package wybory;

public class KandydaciPartiiDanegoOkregu {
    private final Partia partia;
    private final Okreg okreg;

    private final Kandydat[] kandydaciPartii;

    public KandydaciPartiiDanegoOkregu(Partia partia, Okreg okreg, Kandydat[] kandydaciPartii) {
        this.partia = partia;
        this.okreg = okreg;
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
