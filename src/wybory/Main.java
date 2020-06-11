package wybory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s1 = new Scanner(new File(args[0]));
        Scanner s2 = new Scanner(new File(args[0]));
        Scanner s3 = new Scanner(new File(args[0]));

        stworzSwiat(s1, new MetodaHareaNiemeyera());
        stworzSwiat(s2, new MetodaDHondta());
        stworzSwiat(s3, new MetodaSaintLague());
    }

    public static void przeprowadzWyboryWybranaMetoda(Okreg[] tablicaOkregow, Partia[] tablicaPartii, DzialaniaWKampanii[] tablicaDzialan, Metoda metoda) {
        Bajtocja bajtocja = new Bajtocja();
        bajtocja.przeprowadzWybory(tablicaOkregow, tablicaPartii, tablicaDzialan, metoda);
    }

    private static void stworzSwiat(Scanner s, Metoda metoda) {
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
        przeprowadzWyboryWybranaMetoda(tablicaOkregow, tablicaPartii, tablicaDzialan, metoda);
        System.out.println("");
    }
}