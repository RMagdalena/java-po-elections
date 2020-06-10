package wybory;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BajtocjaTest {

    @Test
    void test() {

        System.out.println("test");
    }

    @Test
    void wypiszPosumowanie() {
        Bajtocja bajtocja = new Bajtocja();

        Okreg o1 = new Okreg(1);

        Okreg[] okregi = new Okreg[]{o1};

        // PARTIE

        int budzet = 1000;
        Strategia skromna = new StrategiaSkromna();
        Strategia wlasna = new StrategiaWlasna();
        Strategia zachlanna = new StrategiaZachlanna();
        Strategia zRozmachem = new StrategiaZRozmachem();

        Partia PartiaA = new Partia("PartiaA", budzet, skromna);
        Partia[] partie = new Partia[]{PartiaA};

        // KANDYDACI

        int[] cechyK1 = new int[]{-23, -95};
        Kandydat k1 = new Kandydat("k", "pierwszy", PartiaA, 1, cechyK1);
        Kandydat[] k1A = new Kandydat[]{k1};
        KandydaciPartiiDanegoOkregu kandydaciPartiiDanegoOkregu = new KandydaciPartiiDanegoOkregu(PartiaA, o1, k1A);
        LinkedList<KandydaciPartiiDanegoOkregu> ko1 = new LinkedList<>();
        ko1.add(kandydaciPartiiDanegoOkregu);


        // WYBORCY

        Wyborca w1 = new WyborcaZelaznyPartyjny("Ala", "Partyjny", o1, PartiaA);
        Wyborca w2 = new WyborcaZelaznyPartyjnyKandydata("Basia", "Kandydata", o1, PartiaA, 1);
        Wyborca w3 = new WyborcaJednocechowy("Celina", "Min", o1, 1, true, false);
        Wyborca w4 = new WyborcaJednocechowy("Dorota", "Maks", o1, 2, false, true);
        int[] wagiW5 = new int[]{58, 86};
        Wyborca w5 = new WyborcaWszechstronny("Ela", "Wszechstronny", o1, wagiW5);
        Wyborca w6 = new WyborcaJednocechowyPartyjny("Fiona", "Min", o1, 2, true, false, PartiaA);
        Wyborca w7 = new WyborcaJednocechowyPartyjny("Gertruda", "Maks", o1, 1, false, true, PartiaA);
        int[] wagiW8 = new int[]{71, -25};
        Wyborca w8 = new WyborcaWszechstronnyPartyjny("Hania", "Partyjny", o1, wagiW8, PartiaA);
        int[] wagiW9 = new int[]{1, 90};
        Wyborca w9 = new WyborcaWszechstronnyPartyjny("Iga", "Partyjny", o1, wagiW9, PartiaA);
        int[] wagiW10 = new int[]{-87, 1};
        Wyborca w10 = new WyborcaWszechstronnyPartyjny("Joanna", "Partyjny", o1, wagiW10, PartiaA);


        LinkedList<Wyborca> wyborcyOkregu1 = new LinkedList<>();
        wyborcyOkregu1.add(w1);
        wyborcyOkregu1.add(w2);
        wyborcyOkregu1.add(w3);
        wyborcyOkregu1.add(w4);
        wyborcyOkregu1.add(w5);
        wyborcyOkregu1.add(w6);
        wyborcyOkregu1.add(w7);
        wyborcyOkregu1.add(w8);
        wyborcyOkregu1.add(w9);
        wyborcyOkregu1.add(w10);

        w1.setKandydatNaKtoregoGlosuje(k1);
        w2.setKandydatNaKtoregoGlosuje(k1);
        w3.setKandydatNaKtoregoGlosuje(k1);
        w4.setKandydatNaKtoregoGlosuje(k1);
        w5.setKandydatNaKtoregoGlosuje(k1);
        w6.setKandydatNaKtoregoGlosuje(k1);
        w7.setKandydatNaKtoregoGlosuje(k1);
        w8.setKandydatNaKtoregoGlosuje(k1);
        w9.setKandydatNaKtoregoGlosuje(k1);
        w10.setKandydatNaKtoregoGlosuje(k1);

        o1.setListaWyborcow(wyborcyOkregu1);
        o1.setWszyscyKandydaciOkregu(ko1);
        WynikiGlosowania wynikiGlosowania = new WynikiGlosowania(partie, new int[]{345});
        o1.setWynikiGlosowania(wynikiGlosowania);
        PartiaA.setWszyscyKandydaciPartii(ko1);
        o1.setPrzydzieloneMandaty(new int[]{12});

        bajtocja.wypiszPosumowanie(okregi, partie, new MetodaDHondta());
    }

    @Test
    void przeprowadzWybory() {
        Metoda metoda1 = new MetodaHareaNiemeyera();
        Metoda metoda2 = new MetodaSaintLague();
        Metoda metoda3 = new MetodaDHondta();


        // OKREGI

        Okreg o1 = new Okreg(1);
//        Okreg o2 = new Okreg(2, );
//        Okreg o3 = new Okreg(3, );

        Okreg[] okregi = new Okreg[]{o1};
//        Okreg[] okregi = new Okreg[]{o1, o2, o3};

        // PARTIE

        int budzet = 1000;
        Strategia skromna = new StrategiaSkromna();
        Strategia wlasna = new StrategiaWlasna();
        Strategia zachlanna = new StrategiaZachlanna();
        Strategia zRozmachem = new StrategiaZRozmachem();

        Partia PartiaA = new Partia("PartiaA", budzet, skromna);
//        Partia PartiaB = new Partia("PartiaB", budzet, wlasna);
//        Partia PartiaC = new Partia("PartiaC", budzet, zachlanna);
//        Partia PartiaD = new Partia("PartiaD", budzet, zRozmachem);
        Partia[] partie = new Partia[]{PartiaA};
//        Partia[] partie = new Partia[]{PartiaA, PartiaB, PartiaC, PartiaB};

        // KANDYDACI

        int[] cechyK1 = new int[]{-23, -95};

        Kandydat k1 = new Kandydat("k", "pierwszy", PartiaA, 1, cechyK1);

        Kandydat[] k1A = new Kandydat[]{k1};

        KandydaciPartiiDanegoOkregu kandydaciPartiiDanegoOkregu = new KandydaciPartiiDanegoOkregu(PartiaA, o1, k1A);

        LinkedList<KandydaciPartiiDanegoOkregu> ko1 = new LinkedList<>();

        ko1.add(kandydaciPartiiDanegoOkregu);

//        int[] cechyK2 = new int[]{-23, -95};
//        Kandydat k2 = new Kandydat("k", "drugi", PartiaB, 2, cechyK2);
//        int[] cechyK3 = new int[]{-23, -95};
//        Kandydat k3 = new Kandydat("k", "trzeci", PartiaC, 3, cechyK3);
//        int[] cechyK4 = new int[]{-23, -95};
//        Kandydat k4 = new Kandydat("k", "czwarty", PartiaD, 4, cechyK4);
//
//        int[] cechyK5 = new int[]{-23, -95};
//        Kandydat k5 = new Kandydat("k", "piaty", PartiaA, 1, cechyK5);
//        int[] cechyK6 = new int[]{-23, -95};
//        Kandydat k6 = new Kandydat("k", "szosty", PartiaB, 2, cechyK6);
//        int[] cechyK7 = new int[]{-23, -95};
//        Kandydat k7 = new Kandydat("k", "siodmy", PartiaC, 3, cechyK7);
//        int[] cechyK8 = new int[]{-23, -95};
//        Kandydat k8 = new Kandydat("k", "osmy", PartiaD, 4, cechyK8);
//
//        int[] cechyK9 = new int[]{-23, -95};
//        Kandydat k9 = new Kandydat("k", "dziewiaty", PartiaA, 1, cechyK9);
//        int[] cechyK10 = new int[]{-23, -95};
//        Kandydat k10 = new Kandydat("k", "dziesiaty", PartiaB, 2, cechyK10);
//        int[] cechyK11 = new int[]{-23, -95};
//        Kandydat k11 = new Kandydat("k", "jedenasty", PartiaC, 3, cechyK11);
//        int[] cechyK12 = new int[]{-23, -95};
//        Kandydat k12 = new Kandydat("k", "dwunasty", PartiaD, 4, cechyK12);
//
//
//        kandydaciOkregu1.add(k2);
//        kandydaciOkregu1.add(k3);
//        kandydaciOkregu1.add(k4);
//        LinkedList<Kandydat> kandydaciOkregu2 = new LinkedList<>();
//        kandydaciOkregu2.add(k5);
//        kandydaciOkregu2.add(k6);
//        kandydaciOkregu2.add(k7);
//        kandydaciOkregu2.add(k8);
//        LinkedList<Kandydat> kandydaciOkregu3 = new LinkedList<>();
//        kandydaciOkregu3.add(k9);
//        kandydaciOkregu3.add(k10);
//        kandydaciOkregu3.add(k11);
//        kandydaciOkregu3.add(k12);


        // WYBORCY


        Wyborca w1 = new WyborcaZelaznyPartyjny("Zelazny", "Partyjny", o1, PartiaA);
        Wyborca w2 = new WyborcaZelaznyPartyjnyKandydata("Zelazny", "Kandydata", o1, PartiaA, 1);
        Wyborca w3 = new WyborcaJednocechowy("Jednocechowy", "Min", o1, 1, true, false);
        Wyborca w4 = new WyborcaJednocechowy("Jednocechowy", "Maks", o1, 2, false, true);
        int[] wagiW5 = new int[]{58, 86};
        Wyborca w5 = new WyborcaWszechstronny("Wszechstronny", "Wszechstronny", o1, wagiW5);
        Wyborca w6 = new WyborcaJednocechowyPartyjny("Partyjny", "Min", o1, 2, true, false, PartiaA);
        Wyborca w7 = new WyborcaJednocechowyPartyjny("Partyjny", "Maks", o1, 1, false, true, PartiaA);
        int[] wagiW8 = new int[]{71, -25};
        Wyborca w8 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o1, wagiW8, PartiaA);
        int[] wagiW9 = new int[]{1, 90};
        Wyborca w9 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o1, wagiW9, PartiaA);
        int[] wagiW10 = new int[]{-87, 1};
        Wyborca w10 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o1, wagiW10, PartiaA);

//        Wyborca w11 = new WyborcaZelaznyPartyjny("Zelazny", "Partyjny", o2, PartiaB);
//        Wyborca w12 = new WyborcaZelaznyPartyjnyKandydata("Zelazny", "Kandydata", o1, PartiaB, 1);
//        Wyborca w13 = new WyborcaJednocechowy("Jednocechowy", "Min", o2, 2, true, false);
//        Wyborca w14 = new WyborcaJednocechowy("Jednocechowy", "Maks", o2, 1, false, true);
//        Wyborca w15 = new WyborcaWszechstronny("Wszechstronny", "Wszechstronny", o2, wagiW5);
//        Wyborca w16 = new WyborcaJednocechowyPartyjny("Partyjny", "Min", o2, 2, true, false, PartiaD);
//        Wyborca w17 = new WyborcaJednocechowyPartyjny("Partyjny", "Maks", o2, 1, false, true, PartiaC);
//        Wyborca w18 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW8, PartiaB);
//        Wyborca w19 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW8_1, PartiaC);
//        Wyborca w20 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW8_2, PartiaD);
//
//        Wyborca w21 = new WyborcaZelaznyPartyjny("Zelazny", "Partyjny", o3, PartiaB);
//        Wyborca w22 = new WyborcaZelaznyPartyjnyKandydata("Zelazny", "Kandydata", o3, PartiaB, 1);
//        Wyborca w23 = new WyborcaJednocechowy("Jednocechowy", "Min", o3, 1, true, false);
//        Wyborca w24 = new WyborcaJednocechowy("Jednocechowy", "Maks", o3, 2, false, true);
//        Wyborca w25 = new WyborcaWszechstronny("Wszechstronny", "Wszechstronny", o3, wagiW5);
//        Wyborca w26 = new WyborcaJednocechowyPartyjny("Partyjny", "Min", o3, 2, true, false, PartiaD);
//        Wyborca w27 = new WyborcaJednocechowyPartyjny("Partyjny", "Maks", o3, 1, false, true, PartiaC);
//        Wyborca w28 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW8, PartiaB);
//        Wyborca w29 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW8_1, PartiaC);
//        Wyborca w30 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW8_2, PartiaD);

        LinkedList<Wyborca> wyborcyOkregu1 = new LinkedList<>();
        wyborcyOkregu1.add(w1);
        wyborcyOkregu1.add(w2);
        wyborcyOkregu1.add(w3);
        wyborcyOkregu1.add(w4);
        wyborcyOkregu1.add(w5);
        wyborcyOkregu1.add(w6);
        wyborcyOkregu1.add(w7);
        wyborcyOkregu1.add(w8);
        wyborcyOkregu1.add(w9);
        wyborcyOkregu1.add(w10);

//        LinkedList<Wyborca> wyborcyOkregu2 = (LinkedList<Wyborca>) Arrays.asList(w11, w12, w13, w14, w15, w16, w17, w18, w19, w20);
//        LinkedList<Wyborca> wyborcyOkregu3 = (LinkedList<Wyborca>) Arrays.asList(w21, w22, w23, w24, w25, w26, w27, w28, w29, w30);

        o1.setListaWyborcow(wyborcyOkregu1);
        o1.setWszyscyKandydaciOkregu(ko1);
        PartiaA.setWszyscyKandydaciPartii(ko1);

        // DZIALANIA
        int[] opis1 = new int[]{-9, 3};
        DzialaniaWKampanii d1 = new DzialaniaWKampanii(opis1);
        int[] opis2 = new int[]{7, -6};
        DzialaniaWKampanii d2 = new DzialaniaWKampanii(opis2);

        DzialaniaWKampanii[] dzialaniaWKampanii = new DzialaniaWKampanii[]{d1, d2};


        // test

        Bajtocja bajtocja = new Bajtocja();

        bajtocja.przeprowadzWybory(okregi, partie, dzialaniaWKampanii, metoda1);

        System.out.println("test");
    }
}