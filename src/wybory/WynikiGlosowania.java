package wybory;

import java.util.LinkedList;

public class WynikiGlosowania {
    private LinkedList<String> listaPartii;
    private LinkedList<Integer> glosyOddaneNaPoszczegolnePartie;
    private LinkedList<Integer> glosyOddaneNaPoszczegolnychKandydatow;

    public WynikiGlosowania(LinkedList<String> listaPartii, LinkedList<Integer> glosyOddaneNaPoszczegolnePartie,
                            LinkedList<Integer> glosyOddaneNaPoszczegolnychKandydatow) {
        this.listaPartii = listaPartii;
        this.glosyOddaneNaPoszczegolnePartie = glosyOddaneNaPoszczegolnePartie;
        this.glosyOddaneNaPoszczegolnychKandydatow = glosyOddaneNaPoszczegolnychKandydatow;
    }


}
