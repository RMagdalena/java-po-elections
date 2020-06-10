package wybory;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private final Partia[] tablicaPartii;
    private final int liczbaCech;
    private final int liczbaDzialan;
    private final Okreg[] tablicaOkregow;
    private final DzialaniaWKampanii[] tablicaDzialan;
    private final Scanner s;
    int[] numeryPolaczonychOkregowPierwszychZPary;
    private int liczbaWyborcow = 0;


    public Interpreter(Scanner s, Partia[] tablicaPartii, Okreg[] tablicaOkregow, int liczbaCech, int liczbaDzialan, int liczbaPolaczonychOkregow) {
        this.s = s;
        this.tablicaPartii = tablicaPartii;
        this.tablicaOkregow = tablicaOkregow;
        this.liczbaCech = liczbaCech;
        this.liczbaDzialan = liczbaDzialan;
        this.tablicaDzialan = new DzialaniaWKampanii[liczbaDzialan];
        this.numeryPolaczonychOkregowPierwszychZPary = new int[liczbaPolaczonychOkregow];
    }

    public void stworzSwiatWyborow() {
        stworzOkregi();
        stworzPartie();
        wczytajLiczebnosciOkregow();
        wczytajKandydatowIPrzypiszIchDoOkregow();
        wczytyajWyborcow();
        scalOkregi();
        wczytajMozliweDzialania();
    }

    public void stworzOkregi() {
        String okregiPolaczone = s.nextLine();

        int numerGrupy = 0;

        for (int i = 0; i < tablicaOkregow.length; i++) {
            tablicaOkregow[i] = new Okreg(i + 1);
        }

        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(okregiPolaczone);
        while (m.find()) {
            int numerOkregu1 = Integer.parseInt(m.group(1).split(",")[0]);
            numeryPolaczonychOkregowPierwszychZPary[numerGrupy] = numerOkregu1;
            numerGrupy++;
        }
    }

    public void stworzPartie() {
        String nazwyPartii = s.nextLine();
        String budzetyParti = s.nextLine();
        String strategiePartii = s.nextLine();
        int indeksPartii = 0;
        while (indeksPartii < tablicaPartii.length) {
            String nazwaPartii = nazwyPartii.split(" ")[indeksPartii];
            int budzetPartii = Integer.parseInt(budzetyParti.split(" ")[indeksPartii]);
            String strategia = strategiePartii.split(" ")[indeksPartii];
            Strategia strategiaPartii = rozpoznajStrategie(strategia);

            Partia partia = new Partia(nazwaPartii, budzetPartii, strategiaPartii);
            tablicaPartii[indeksPartii] = partia;
            indeksPartii++;
        }
    }

    public void wczytajLiczebnosciOkregow() {
        String liczebnosci = s.nextLine();
        for (int i = 0; i < tablicaOkregow.length; i++) {
            int liczebnoscOkregu = Integer.parseInt(liczebnosci.split(" ")[i]);
            liczbaWyborcow += liczebnoscOkregu;
            tablicaOkregow[i].setLiczbaWyborcow(liczebnoscOkregu);
            tablicaOkregow[i].setLiczbaMandatow(liczebnoscOkregu / 10);
        }
    }

    public void wczytajKandydatowIPrzypiszIchDoOkregow() {
        //imie nazwisko numerOkregu partia numer cechy
        int liczbaMandatow = liczbaWyborcow / 10;
        int stworzonychKandydatow = 0;
        int liczbaWszystkichKandydatow = liczbaMandatow * tablicaPartii.length;


        for (Okreg okreg : tablicaOkregow) {
            LinkedList<KandydaciPartiiDanegoOkregu> wszyscyKandydaciOkregu = new LinkedList<>();

            Kandydat[] kandydaciOkregu = new Kandydat[okreg.getLiczbaMandatow()];
            for (Partia partia : tablicaPartii) {

                for (int i = 0; i < kandydaciOkregu.length; i++) {
                    String opisKandydata = s.nextLine();
                    String imie = opisKandydata.split(" ")[0];
                    String nazwisko = opisKandydata.split(" ")[1];
                    int numerOkregu = Integer.parseInt(opisKandydata.split(" ")[2]);

                    Partia partiaKandydata = ktoraPartiaSieTakNazywa(opisKandydata.split(" ")[3]);

                    int pozycjaNaLiscie = Integer.parseInt(opisKandydata.split(" ")[4]);
                    int[] tablicaCechKandydata = new int[liczbaCech];
                    for (int j = 0; j < liczbaCech; j++) {
                        tablicaCechKandydata[j] = Integer.parseInt(opisKandydata.split(" ")[j + 5]);
                    }
                    Kandydat kandydat = new Kandydat(imie, nazwisko, partiaKandydata, pozycjaNaLiscie, tablicaCechKandydata);
                    kandydaciOkregu[i] = kandydat;
                }
                KandydaciPartiiDanegoOkregu kandydaciPartiiDanegoOkregu = new KandydaciPartiiDanegoOkregu(partia, okreg, kandydaciOkregu);
                wszyscyKandydaciOkregu.add(kandydaciPartiiDanegoOkregu);
            }
            okreg.setWszyscyKandydaciOkregu(wszyscyKandydaciOkregu);
        }
    }

    public void wczytyajWyborcow() {
        int numerOstatnioDodanegoOkregu = 1;
        LinkedList<Wyborca> listaWyborcow = new LinkedList<>();

        for (int i = 0; i < liczbaWyborcow; i++) {
            String opisWyborcy = s.nextLine();
            String imie = opisWyborcy.split(" ")[0];
            String nazwisko = opisWyborcy.split(" ")[1];
            int numerOkregu = Integer.parseInt(opisWyborcy.split(" ")[2]);
            int typWyborcy = Integer.parseInt(opisWyborcy.split(" ")[3]);

            Wyborca wyborca = stworzWyborce(imie, nazwisko, tablicaOkregow[numerOkregu - 1], typWyborcy, opisWyborcy.split(" "));

            if (numerOkregu != numerOstatnioDodanegoOkregu) {
                tablicaOkregow[numerOstatnioDodanegoOkregu - 1].setListaWyborcow(listaWyborcow);
                listaWyborcow = new LinkedList<>();
            }
            listaWyborcow.add(wyborca);
            numerOstatnioDodanegoOkregu = numerOkregu;
        }
        tablicaOkregow[numerOstatnioDodanegoOkregu - 1].setListaWyborcow(listaWyborcow);
    }

    public void scalOkregi() {
        for (int pierwszyNumerZPary : numeryPolaczonychOkregowPierwszychZPary) {
            tablicaOkregow[pierwszyNumerZPary - 1].scalZOkregiem(tablicaOkregow[pierwszyNumerZPary]);
        }
    }

    public void wczytajMozliweDzialania() {
        for (int numerDzialania = 0; numerDzialania < liczbaDzialan; numerDzialania++) {
            int[] tablicaZmienionychCech = new int[liczbaCech];
            String opisDzialan = s.nextLine();
            for (int i = 0; i < liczbaCech; i++) {
                String str = opisDzialan.split(" ")[i];
                if (str.equals("")) {
                    tablicaZmienionychCech[liczbaCech - 1] = Integer.parseInt(opisDzialan.split(" ")[liczbaCech]);
                    continue;
                }
                tablicaZmienionychCech[i] = Integer.parseInt(str);
            }
            tablicaDzialan[numerDzialania] = new DzialaniaWKampanii(tablicaZmienionychCech);
        }
    }

    public Wyborca stworzWyborce(String imie, String nazwisko, Okreg okreg, int typ, String[] resztaNapisu) {
        if (typ == 1) {
            String nazwaPartii = resztaNapisu[4];
            Partia mojaPartia = ktoraPartiaSieTakNazywa(nazwaPartii);
            return new WyborcaZelaznyPartyjny(imie, nazwisko, okreg, mojaPartia);
        }
        if (typ == 2) {
            String nazwaPartii = resztaNapisu[4];
            int numerKandydata = Integer.parseInt(resztaNapisu[5]);
            Partia mojaPartia = ktoraPartiaSieTakNazywa(nazwaPartii);
            return new WyborcaZelaznyPartyjnyKandydata(imie, nazwisko, okreg, mojaPartia, numerKandydata);
        }

        if (typ == 3) {
            int numerCechy = Integer.parseInt(resztaNapisu[4]);
            return new WyborcaJednocechowy(imie, nazwisko, okreg, numerCechy, true, false);
        }

        if (typ == 4) {
            int numerCechy = Integer.parseInt(resztaNapisu[4]);
            return new WyborcaJednocechowy(imie, nazwisko, okreg, numerCechy, false, true);
        }

        if (typ == 5) {
            int[] tablicaWag = new int[liczbaCech];
            for (int i = 0; i < liczbaCech; i++) {
                tablicaWag[i] = Integer.parseInt(resztaNapisu[4 + i]);
            }

            return new WyborcaWszechstronny(imie, nazwisko, okreg, tablicaWag);
        }

        if (typ == 6) {
            int numerCechy = Integer.parseInt(resztaNapisu[4]);
            String nazwaPartii = resztaNapisu[5];
            Partia mojaPartia = ktoraPartiaSieTakNazywa(nazwaPartii);
            return new WyborcaJednocechowyPartyjny(imie, nazwisko, okreg, numerCechy, true, false, mojaPartia);
        }

        if (typ == 7) {
            int numerCechy = Integer.parseInt(resztaNapisu[4]);
            String nazwaPartii = resztaNapisu[5];
            Partia mojaPartia = ktoraPartiaSieTakNazywa(nazwaPartii);
            return new WyborcaJednocechowyPartyjny(imie, nazwisko, okreg, numerCechy, false, true, mojaPartia);
        }

        if (typ == 8) {
            int[] tablicaWag = new int[liczbaCech];
            for (int i = 0; i < liczbaCech; i++) {
                tablicaWag[i] = Integer.parseInt(resztaNapisu[4 + i]);
            }
            String nazwaPartii = resztaNapisu[4 + liczbaCech];
            Partia mojaPartia = ktoraPartiaSieTakNazywa(nazwaPartii);

            return new WyborcaWszechstronnyPartyjny(imie, nazwisko, okreg, tablicaWag, mojaPartia);
        }
        return null;
    }

    public Partia ktoraPartiaSieTakNazywa(String nazwa) {
        for (Partia partia : tablicaPartii) {
            String nazwaPartii = partia.getNazwaPartii();
            if (nazwaPartii.equals(nazwa)) {
                return partia;
            }
        }
        return null;
    }

    public Strategia rozpoznajStrategie(String strategia) {
        if (strategia.equals("R")) {
            return new StrategiaZRozmachem();
        }
        if (strategia.equals("S")) {
            return new StrategiaSkromna();
        }
        if (strategia.equals("W")) {
            return new StrategiaWlasna();
        }
        if (strategia.equals("Z")) {
            return new StrategiaZachlanna();
        }
        return null;
    }

    public Okreg[] getTabliceOkregow() {
        return tablicaOkregow;
    }

    public Partia[] getTablicePartii() {
        return tablicaPartii;
    }

    public DzialaniaWKampanii[] getTabliceDzialan() {
        return tablicaDzialan;
    }
}
