package wybory;

import java.util.Arrays;

public class Kandydat {
    private final String imie;
    private final String nazwisko;
    private final Partia partia;
    private final int numerNaLiscie;
    private final int[] cechyKandydata;
    private int liczbaGlosow = 0;

    public Kandydat(String imie, String nazwisko, Partia partia, int numerNaLiscie, int[] cechyKandydata) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.partia = partia;
        this.numerNaLiscie = numerNaLiscie;
        this.cechyKandydata = cechyKandydata;
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

}
