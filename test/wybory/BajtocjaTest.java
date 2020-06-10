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
        Okreg o2 = new Okreg(2);
        Okreg o3 = new Okreg(3);

        Okreg[] okregi = new Okreg[]{o1, o2, o3};

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
        KandydaciPartiiDanegoOkregu kandydaciPartiiOkregu1 = new KandydaciPartiiDanegoOkregu(PartiaA, o1, k1A);
        LinkedList<KandydaciPartiiDanegoOkregu> ko1 = new LinkedList<>();
        ko1.add(kandydaciPartiiOkregu1);

        int[] cechyK5 = new int[]{-50, -58};
        Kandydat k5 = new Kandydat("k", "piaty", PartiaA, 1, cechyK5);
        Kandydat[] k2A = new Kandydat[]{k5};
        KandydaciPartiiDanegoOkregu kandydaciPartiiOkregu2 = new KandydaciPartiiDanegoOkregu(PartiaA, o2, k2A);
        LinkedList<KandydaciPartiiDanegoOkregu> ko2 = new LinkedList<>();
        ko2.add(kandydaciPartiiOkregu2);

        int[] cechyK9 = new int[]{45, 33};
        Kandydat k9 = new Kandydat("k", "dziewiaty", PartiaA, 1, cechyK9);
        Kandydat[] k3A = new Kandydat[]{k9};
        KandydaciPartiiDanegoOkregu kandydaciPartiiOkregu3 = new KandydaciPartiiDanegoOkregu(PartiaA, o3, k3A);
        LinkedList<KandydaciPartiiDanegoOkregu> ko3 = new LinkedList<>();
        ko3.add(kandydaciPartiiOkregu3);


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

        Wyborca w11 = new WyborcaZelaznyPartyjny("Zelazny", "Partyjny", o2, PartiaA);
        Wyborca w12 = new WyborcaZelaznyPartyjnyKandydata("Zelazny", "Kandydata", o2, PartiaA, 1);
        Wyborca w13 = new WyborcaJednocechowy("Jednocechowy", "Min", o2, 2, true, false);
        Wyborca w14 = new WyborcaJednocechowy("Jednocechowy", "Maks", o2, 1, false, true);
        Wyborca w15 = new WyborcaWszechstronny("Wszechstronny", "Wszechstronny", o2, wagiW5);
        Wyborca w16 = new WyborcaJednocechowyPartyjny("Partyjny", "Min", o2, 2, true, false, PartiaA);
        Wyborca w17 = new WyborcaJednocechowyPartyjny("Partyjny", "Maks", o2, 1, false, true, PartiaA);
        Wyborca w18 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW8, PartiaA);
        Wyborca w19 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW9, PartiaA);
        Wyborca w20 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW10, PartiaA);

        Wyborca w21 = new WyborcaZelaznyPartyjny("Zelazny", "Partyjny", o3, PartiaA);
        Wyborca w22 = new WyborcaZelaznyPartyjnyKandydata("Zelazny", "Kandydata", o3, PartiaA, 1);
        Wyborca w23 = new WyborcaJednocechowy("Jednocechowy", "Min", o3, 1, true, false);
        Wyborca w24 = new WyborcaJednocechowy("Jednocechowy", "Maks", o3, 2, false, true);
        Wyborca w25 = new WyborcaWszechstronny("Wszechstronny", "Wszechstronny", o3, wagiW5);
        Wyborca w26 = new WyborcaJednocechowyPartyjny("Partyjny", "Min", o3, 2, true, false, PartiaA);
        Wyborca w27 = new WyborcaJednocechowyPartyjny("Partyjny", "Maks", o3, 1, false, true, PartiaA);
        Wyborca w28 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW8, PartiaA);
        Wyborca w29 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW9, PartiaA);
        Wyborca w30 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW9, PartiaA);

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

        LinkedList<Wyborca> wyborcyOkregu2 = new LinkedList<>();
        wyborcyOkregu2.add(w11);
        wyborcyOkregu2.add(w12);
        wyborcyOkregu2.add(w13);
        wyborcyOkregu2.add(w14);
        wyborcyOkregu2.add(w15);
        wyborcyOkregu2.add(w16);
        wyborcyOkregu2.add(w17);
        wyborcyOkregu2.add(w18);
        wyborcyOkregu2.add(w19);
        wyborcyOkregu2.add(w20);

        LinkedList<Wyborca> wyborcyOkregu3 = new LinkedList<>();
        wyborcyOkregu3.add(w21);
        wyborcyOkregu3.add(w22);
        wyborcyOkregu3.add(w23);
        wyborcyOkregu3.add(w24);
        wyborcyOkregu3.add(w25);
        wyborcyOkregu3.add(w26);
        wyborcyOkregu3.add(w27);
        wyborcyOkregu3.add(w28);
        wyborcyOkregu3.add(w29);
        wyborcyOkregu3.add(w30);


        o1.setListaWyborcow(wyborcyOkregu1);
        o1.setWszyscyKandydaciOkregu(ko1);

        o2.setListaWyborcow(wyborcyOkregu2);
        o2.setWszyscyKandydaciOkregu(ko2);

        o3.setListaWyborcow(wyborcyOkregu3);
        o3.setWszyscyKandydaciOkregu(ko3);

        LinkedList<KandydaciPartiiDanegoOkregu> kpA = new LinkedList<>();
        kpA.add(kandydaciPartiiOkregu1);
        kpA.add(kandydaciPartiiOkregu2);
        kpA.add(kandydaciPartiiOkregu3);

        PartiaA.setWszyscyKandydaciPartii(kpA);

        o1.scalZOkregiem(o2);

        WynikiGlosowania wynikiGlosowania12 = new WynikiGlosowania(partie, new int[]{7});
        WynikiGlosowania wynikiGlosowania3 = new WynikiGlosowania(partie, new int[]{5});


//        o1.getOkregScalony().setWynikiGlosowania(wynikiGlosowania12);
//        o3.setWynikiGlosowania(wynikiGlosowania3);


//        bajtocja.wypiszPosumowanie(okregi, partie, new MetodaDHondta());
    }

    @Test
    void przeprowadzWybory() {
        Metoda metoda1 = new MetodaHareaNiemeyera();
        Metoda metoda2 = new MetodaSaintLague();
        Metoda metoda3 = new MetodaDHondta();


        // OKREGI

        Okreg o1 = new Okreg(1);
        Okreg o2 = new Okreg(2);
        Okreg o3 = new Okreg(3);

        Okreg[] okregi = new Okreg[]{o1, o2, o3};

        // PARTIE

        int budzet = 1000;
        Strategia skromna = new StrategiaSkromna();
        Strategia wlasna = new StrategiaWlasna();
        Strategia zachlanna = new StrategiaZachlanna();
        Strategia zRozmachem = new StrategiaZRozmachem();

        Partia PartiaA = new Partia("PartiaA", budzet, skromna);
//        Partia PartiaA = new Partia("PartiaA", budzet, wlasna);
//        Partia PartiaA = new Partia("PartiaA", budzet, zachlanna);
//        Partia PartiaA = new Partia("PartiaA", budzet, zRozmachem);
        Partia[] partie = new Partia[]{PartiaA};
//        Partia[] partie = new Partia[]{PartiaA, PartiaA, PartiaA, PartiaA};

        // KANDYDACI

        int[] cechyK1 = new int[]{-23, -95};

        Kandydat k1 = new Kandydat("k", "pierwszy", PartiaA, 1, cechyK1);

        Kandydat[] k1A = new Kandydat[]{k1};

        KandydaciPartiiDanegoOkregu kandydaciPartiiOkregu1 = new KandydaciPartiiDanegoOkregu(PartiaA, o1, k1A);

        LinkedList<KandydaciPartiiDanegoOkregu> ko1 = new LinkedList<>();

        ko1.add(kandydaciPartiiOkregu1);

//        int[] cechyK2 = new int[]{-23, -95};
//        Kandydat k2 = new Kandydat("k", "drugi", PartiaA, 2, cechyK2);
//        int[] cechyK3 = new int[]{-23, -95};
//        Kandydat k3 = new Kandydat("k", "trzeci", PartiaA, 3, cechyK3);
//        int[] cechyK4 = new int[]{-23, -95};
//        Kandydat k4 = new Kandydat("k", "czwarty", PartiaA, 4, cechyK4);
//
        int[] cechyK5 = new int[]{-50, -58};

        Kandydat k5 = new Kandydat("k", "piaty", PartiaA, 1, cechyK5);

        Kandydat[] k2A = new Kandydat[]{k5};

        KandydaciPartiiDanegoOkregu kandydaciPartiiOkregu2 = new KandydaciPartiiDanegoOkregu(PartiaA, o2, k2A);

        LinkedList<KandydaciPartiiDanegoOkregu> ko2 = new LinkedList<>();

        ko2.add(kandydaciPartiiOkregu2);

//        int[] cechyK6 = new int[]{-23, -95};
//        Kandydat k6 = new Kandydat("k", "szosty", PartiaA, 2, cechyK6);
//        int[] cechyK7 = new int[]{-23, -95};
//        Kandydat k7 = new Kandydat("k", "siodmy", PartiaA, 3, cechyK7);
//        int[] cechyK8 = new int[]{-23, -95};
//        Kandydat k8 = new Kandydat("k", "osmy", PartiaA, 4, cechyK8);
//
        int[] cechyK9 = new int[]{45, 33};

        Kandydat k9 = new Kandydat("k", "dziewiaty", PartiaA, 1, cechyK9);

        Kandydat[] k3A = new Kandydat[]{k9};

        KandydaciPartiiDanegoOkregu kandydaciPartiiOkregu3 = new KandydaciPartiiDanegoOkregu(PartiaA, o3, k3A);

        LinkedList<KandydaciPartiiDanegoOkregu> ko3 = new LinkedList<>();

        ko3.add(kandydaciPartiiOkregu3);

//        int[] cechyK10 = new int[]{-23, -95};
//        Kandydat k10 = new Kandydat("k", "dziesiaty", PartiaA, 2, cechyK10);
//        int[] cechyK11 = new int[]{-23, -95};
//        Kandydat k11 = new Kandydat("k", "jedenasty", PartiaA, 3, cechyK11);
//        int[] cechyK12 = new int[]{-23, -95};
//        Kandydat k12 = new Kandydat("k", "dwunasty", PartiaA, 4, cechyK12);
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

        Wyborca w11 = new WyborcaZelaznyPartyjny("Zelazny", "Partyjny", o2, PartiaA);
        Wyborca w12 = new WyborcaZelaznyPartyjnyKandydata("Zelazny", "Kandydata", o1, PartiaA, 1);
        Wyborca w13 = new WyborcaJednocechowy("Jednocechowy", "Min", o2, 2, true, false);
        Wyborca w14 = new WyborcaJednocechowy("Jednocechowy", "Maks", o2, 1, false, true);
        Wyborca w15 = new WyborcaWszechstronny("Wszechstronny", "Wszechstronny", o2, wagiW5);
        Wyborca w16 = new WyborcaJednocechowyPartyjny("Partyjny", "Min", o2, 2, true, false, PartiaA);
        Wyborca w17 = new WyborcaJednocechowyPartyjny("Partyjny", "Maks", o2, 1, false, true, PartiaA);
        Wyborca w18 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW8, PartiaA);
        Wyborca w19 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW9, PartiaA);
        Wyborca w20 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o2, wagiW10, PartiaA);

        Wyborca w21 = new WyborcaZelaznyPartyjny("Zelazny", "Partyjny", o3, PartiaA);
        Wyborca w22 = new WyborcaZelaznyPartyjnyKandydata("Zelazny", "Kandydata", o3, PartiaA, 1);
        Wyborca w23 = new WyborcaJednocechowy("Jednocechowy", "Min", o3, 1, true, false);
        Wyborca w24 = new WyborcaJednocechowy("Jednocechowy", "Maks", o3, 2, false, true);
        Wyborca w25 = new WyborcaWszechstronny("Wszechstronny", "Wszechstronny", o3, wagiW5);
        Wyborca w26 = new WyborcaJednocechowyPartyjny("Partyjny", "Min", o3, 2, true, false, PartiaA);
        Wyborca w27 = new WyborcaJednocechowyPartyjny("Partyjny", "Maks", o3, 1, false, true, PartiaA);
        Wyborca w28 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW8, PartiaA);
        Wyborca w29 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW9, PartiaA);
        Wyborca w30 = new WyborcaWszechstronnyPartyjny("Wszechstronny", "Partyjny", o3, wagiW9, PartiaA);

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

        LinkedList<Wyborca> wyborcyOkregu2 = new LinkedList<>();
        wyborcyOkregu1.add(w11);
        wyborcyOkregu1.add(w12);
        wyborcyOkregu1.add(w13);
        wyborcyOkregu1.add(w14);
        wyborcyOkregu1.add(w15);
        wyborcyOkregu1.add(w16);
        wyborcyOkregu1.add(w17);
        wyborcyOkregu1.add(w18);
        wyborcyOkregu1.add(w19);
        wyborcyOkregu1.add(w20);

        LinkedList<Wyborca> wyborcyOkregu3 = new LinkedList<>();
        wyborcyOkregu1.add(w21);
        wyborcyOkregu1.add(w22);
        wyborcyOkregu1.add(w23);
        wyborcyOkregu1.add(w24);
        wyborcyOkregu1.add(w25);
        wyborcyOkregu1.add(w26);
        wyborcyOkregu1.add(w27);
        wyborcyOkregu1.add(w28);
        wyborcyOkregu1.add(w29);
        wyborcyOkregu1.add(w30);


        o1.setListaWyborcow(wyborcyOkregu1);
        o1.setWszyscyKandydaciOkregu(ko1);

        o2.setListaWyborcow(wyborcyOkregu2);
        o2.setWszyscyKandydaciOkregu(ko2);

        o3.setListaWyborcow(wyborcyOkregu3);
        o3.setWszyscyKandydaciOkregu(ko3);

        LinkedList<KandydaciPartiiDanegoOkregu> kpA = new LinkedList<>();
        kpA.add(kandydaciPartiiOkregu1);
        kpA.add(kandydaciPartiiOkregu2);
        kpA.add(kandydaciPartiiOkregu3);

        PartiaA.setWszyscyKandydaciPartii(kpA);

        // DZIALANIA
        int[] opis1 = new int[]{-9, 3};
        DzialaniaWKampanii d1 = new DzialaniaWKampanii(opis1);
        int[] opis2 = new int[]{7, -6};
        DzialaniaWKampanii d2 = new DzialaniaWKampanii(opis2);

        DzialaniaWKampanii[] dzialaniaWKampanii = new DzialaniaWKampanii[]{d1, d2};


        // scalanie

//        o1.scalZOkregiem(o2);

        // test

        Bajtocja bajtocja = new Bajtocja();

        bajtocja.przeprowadzWybory(okregi, partie, dzialaniaWKampanii, metoda1);

        System.out.println("test");
    }
}