package wybory;

import java.util.LinkedList;
import java.lang.Math;
import java.util.Random;

public class MetodaHareaNiemeyera implements Metoda {
    @Override
    public int[] rozdajMandatyWOkregu(WynikiGlosowania wynikiGlosowaniaOkregu, int liczbaMandatowOkregu) {

        LinkedList<Float> proporcje = new LinkedList<>();
        LinkedList<Float> poPrzecinku = new LinkedList<>();

        int[] glosyNaPartieWOkregu = wynikiGlosowaniaOkregu.getGlosyOddaneNaPoszczegolnePartie();

        int sumaGlosowWOkregu = sumaGlosowWOkregu(glosyNaPartieWOkregu);

        Partia[] listaPartii = wynikiGlosowaniaOkregu.getPartie();
        int[] wykazMandatow = new int[listaPartii.length];
        int rozdzieloneMandaty = 0;
        float proporcjaDlaPartii;
        for (int i = 0; i < glosyNaPartieWOkregu.length; i++) {
            proporcjaDlaPartii = ((float) glosyNaPartieWOkregu[i] * liczbaMandatowOkregu) / ((float) sumaGlosowWOkregu);
            proporcje.add(proporcjaDlaPartii);
            wykazMandatow[i] = (int) Math.floor(proporcjaDlaPartii);
            rozdzieloneMandaty += wykazMandatow[i];
            poPrzecinku.add(proporcjaDlaPartii - wykazMandatow[i]);
        }
        return rozdzielPoPrzecinku(wykazMandatow, rozdzieloneMandaty, liczbaMandatowOkregu, poPrzecinku);
    }

    private int sumaGlosowWOkregu(int[] glosyNaPartieWOkregu) {
        int sumaGlosowWOkregu = 0;
        for (int i : glosyNaPartieWOkregu) {
            sumaGlosowWOkregu += i;
        }
        return sumaGlosowWOkregu;
    }

    private int[] rozdzielPoPrzecinku(int[] wykazMandatow, int rozdzieloneMandaty, int liczbaMandatowOkregu, LinkedList<Float> poPrzecinku) {
        int[] wynik = wykazMandatow;

        while (rozdzieloneMandaty != liczbaMandatowOkregu) {
            float najwiekszaCzescUlamkowa = 0;
            int numerPartii = 0;
            LinkedList<Integer> wybranePartie = new LinkedList<>();
            for (int i = 0; i < poPrzecinku.size(); i++) {
                if (poPrzecinku.get(i) > najwiekszaCzescUlamkowa) {
                    najwiekszaCzescUlamkowa = poPrzecinku.get(i);
                    numerPartii = i;
                    wybranePartie = new LinkedList<>();
                    wybranePartie.add(numerPartii);
                }
                else if (poPrzecinku.get(i) == najwiekszaCzescUlamkowa) {
                    wybranePartie.add(i);
                }
            }
            numerPartii = losujNumerPartii(wybranePartie);
            poPrzecinku.set(numerPartii, (float) 0);
            wynik[numerPartii]++;
            rozdzieloneMandaty++;
        }
        return wynik;
    }

    private int losujNumerPartii(LinkedList<Integer> wybranePartie) {
        Random r = new Random();
        int numerPartiiNaLiscie = r.nextInt(wybranePartie.size());
        return wybranePartie.get(numerPartiiNaLiscie);
    }

    @Override
    public String toString() {
        return "Metoda Hare’a-Niemeyera\n";
    }
}

