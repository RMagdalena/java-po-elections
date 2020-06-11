package wybory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

abstract public class MetodaZDzielnikiem implements Metoda {

    abstract protected int podajWartosc();

    @Override
    public int[] rozdajMandatyWOkregu(WynikiGlosowania wynikiGlosowaniaOkregu, int liczbaMandatowOkregu) {

        Partia[] partie = wynikiGlosowaniaOkregu.getPartie();

        int[] glosyNaPartie = wynikiGlosowaniaOkregu.getGlosyOddaneNaPoszczegolnePartie();
        int[] wykazMandatow = new int[partie.length];
        int rozdzieloneMandaty = 0;

        // klucz to numer partii, wartosc to dzielnik
        Map<Integer, Integer> aktualnyPodzial = new HashMap<>();

        // poczatkowe wypelnienie mapy
        for (int i = 0; i < partie.length; i++) {
            aktualnyPodzial.put(i, 1);
            wykazMandatow[i] = 0;
        }

        while (rozdzieloneMandaty != liczbaMandatowOkregu) {
            float maksymalnaWartosc = 0;

            int numerWybranejPartii = numerWybranejPartii(partie, glosyNaPartie, aktualnyPodzial, maksymalnaWartosc);

            int wartosc = podajWartosc();
            aktualnyPodzial.replace(numerWybranejPartii, aktualnyPodzial.get(numerWybranejPartii) + wartosc);
            wykazMandatow[numerWybranejPartii]++;
            rozdzieloneMandaty++;
        }
        return wykazMandatow;
    }


    protected int numerWybranejPartii(Partia[] partie, int[] glosyNaPartie, Map<Integer, Integer> aktualnyPodzial, float maksymalnaWartosc) {

        LinkedList<Integer> wybranePartie = new LinkedList<>();
        for (int i = 0; i < partie.length; i++) {
            float liczbaGlosowPrzezDzielnik = (float) glosyNaPartie[i] / aktualnyPodzial.get(i);
            int numerPartii = -1;
            if (liczbaGlosowPrzezDzielnik > maksymalnaWartosc) {
                maksymalnaWartosc = liczbaGlosowPrzezDzielnik;
                numerPartii = i;
                wybranePartie = new LinkedList<>();
                wybranePartie.add(numerPartii);
            }
            else if (liczbaGlosowPrzezDzielnik == maksymalnaWartosc) {
                wybranePartie.add(i);
            }
        }
        int wynik = losujNumerPartii(wybranePartie);
        return wynik;
    }

    protected int losujNumerPartii(LinkedList<Integer> wybranePartie) {
        Random r = new Random();
        int numerPartiiNaLiscie = r.nextInt(wybranePartie.size());
        return wybranePartie.get(numerPartiiNaLiscie);
    }

}
