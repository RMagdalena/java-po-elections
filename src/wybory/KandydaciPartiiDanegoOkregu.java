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

    public Okreg getOkreg() {
        return okreg;
    }

    public Kandydat[] getKandydaciPartii() {
        return kandydaciPartii;
    }
}
