package wybory;

public class Main {

    public void wypiszWynik() {
        // przykladowe dane
        Okreg[] okregi = new Okreg[1];
        Partia[] partie = new Partia[1];
        int cechy = 4;
        DzialaniaWKampanii[] dzialaniaWKampanii = new DzialaniaWKampanii[5];
        Metoda metoda = new MetodaHareaNiemeyera();
        // koniec przykladowych danych

        Bajtocja bajtocja = new Bajtocja();

        metoda = new MetodaDHondta();
        bajtocja.przeprowadzWybory(okregi, partie, dzialaniaWKampanii, metoda);

        metoda = new MetodaSaintLague();
        bajtocja.przeprowadzWybory(okregi, partie, dzialaniaWKampanii, metoda);

        metoda = new MetodaHareaNiemeyera();
        bajtocja.przeprowadzWybory(okregi, partie, dzialaniaWKampanii, metoda);


    }

}
