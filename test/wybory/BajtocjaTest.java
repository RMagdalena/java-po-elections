package wybory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BajtocjaTest {

    @Test
    void sortuj() {

        DzialaniaWKampanii dzialanie1 = new DzialaniaWKampanii(new int[]{-1, -1, -1, -1});
        DzialaniaWKampanii dzialanie2 = new DzialaniaWKampanii(new int[]{2, 2, 2, 2});
        DzialaniaWKampanii dzialanie3 = new DzialaniaWKampanii(new int[]{3, 3, 3, 3});
        DzialaniaWKampanii dzialanie4 = new DzialaniaWKampanii(new int[]{4, 4, 4, 4});

        DzialaniaWKampanii[] tablicaDzialan = new DzialaniaWKampanii[]{dzialanie3, dzialanie1, dzialanie4, dzialanie2};

        System.out.println(tablicaDzialan[0].toString());
    }

    @Test
    void przeprowadzWybory() {
        Okreg[] okregi = new Okreg[5];
        Partia[] partie = new Partia[5];
        int cechy = 4;
        DzialaniaWKampanii[] dzialaniaWKampanii = new DzialaniaWKampanii[5];
        Metoda metoda = new MetodaHareaNiemeyera();

        Bajtocja bajtocja = new Bajtocja();

        bajtocja.przeprowadzWybory(okregi, partie, cechy, dzialaniaWKampanii, metoda);

        System.out.println("test");
    }
}