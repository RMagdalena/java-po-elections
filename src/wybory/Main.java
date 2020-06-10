package wybory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Okreg[] tablicaOkregow = new Okreg[s.nextInt()];
        Partia[] tablicaPartii = new Partia[s.nextInt()];

        int liczbaDzialan = s.nextInt();
        int liczbaCech = s.nextInt();
        int liczbaPolaczonychOkregow = s.nextInt();

        Interpreter interpreter = new Interpreter(s, tablicaPartii, tablicaOkregow, liczbaCech, liczbaDzialan, liczbaPolaczonychOkregow);
        interpreter.stworzSwiatWyborow();
        tablicaOkregow = interpreter.getTabliceOkregow();
        tablicaPartii = interpreter.getTablicePartii();
        DzialaniaWKampanii[] tablicaDzialan = interpreter.getTabliceDzialan();

        przeprowadzWyboryWybranaMetoda(tablicaOkregow, tablicaPartii, tablicaDzialan, new MetodaSaintLague());
        System.out.println("");
        przeprowadzWyboryWybranaMetoda(tablicaOkregow, tablicaPartii, tablicaDzialan, new MetodaHareaNiemeyera());
        System.out.println("");
        przeprowadzWyboryWybranaMetoda(tablicaOkregow, tablicaPartii, tablicaDzialan, new MetodaDHondta());
    }

    public static void przeprowadzWyboryWybranaMetoda(Okreg[] tablicaOkregow, Partia[] tablicaPartii, DzialaniaWKampanii[] tablicaDzialan, Metoda metoda) {
        Okreg[] tablicaOkregowKopia = tablicaOkregow.clone();
        Partia[] tablicaPartiiKopia = tablicaPartii.clone();
        Bajtocja bajtocja = new Bajtocja();
        bajtocja.przeprowadzWybory(tablicaOkregowKopia, tablicaPartiiKopia, tablicaDzialan, metoda);
    }
}