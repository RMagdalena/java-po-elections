package wybory;

import java.util.LinkedList;

public class WynikiGlosowania {
    private final Partia[] partie;
    private final int[] glosyOddaneNaPoszczegolnePartie;

    public WynikiGlosowania(Partia[] partie, int[] glosyOddaneNaPoszczegolnePartie) {
        this.partie = partie;
        this.glosyOddaneNaPoszczegolnePartie = glosyOddaneNaPoszczegolnePartie;
    }

    public Partia[] getPartie() {
        return partie;
    }

    public int[] getGlosyOddaneNaPoszczegolnePartie() {
        return glosyOddaneNaPoszczegolnePartie;
    }

//    public StringBuilder wypisz() {
//        StringBuilder wynik = new StringBuilder();
//        for (int i = 0; i < partie.length; i++) {
//            if (partie[i] != null) {
//                wynik.append("___" + partie[i].getNazwaPartii() + " " + glosyOddaneNaPoszczegolnePartie[i] + '\n');
//            }
//        }
//        return wynik;
//    }
}
