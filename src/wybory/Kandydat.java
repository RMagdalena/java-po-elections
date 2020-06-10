package wybory;

public class Kandydat {
    private final String imie;
    private final String nazwisko;
    private final Partia partia;
    private final int numerNaLiscie;
    private final int[] cechyKandydata;
    private int liczbaGlosow;

    public Kandydat(String imie, String nazwisko, Partia partia, int numerNaLiscie, int[] cechyKandydata) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.partia = partia;
        this.numerNaLiscie = numerNaLiscie;
        this.cechyKandydata = cechyKandydata;
        this.liczbaGlosow = 0;
    }

    public Partia getPartia() {
        return partia;
    }

    public int getNumerNaLiscie() {
        return numerNaLiscie;
    }

    public int[] getCechyKandydata() {
        return cechyKandydata;
    }

    public void dodajGlosy() {
        this.liczbaGlosow++;
    }

    public String wypiszImieNazwisko() {
        return imie + " " + nazwisko;
    }

    public StringBuilder wypisz() {
        StringBuilder wynik = new StringBuilder();
        wynik.append(imie + " " + nazwisko + " " + partia.getNazwaPartii() + " " + numerNaLiscie + " " + liczbaGlosow + "\n");
        return wynik;
    }
}
