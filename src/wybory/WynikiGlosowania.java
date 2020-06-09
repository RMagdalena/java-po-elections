package wybory;

import java.util.LinkedList;

public class WynikiGlosowania {
    private final LinkedList<String> listaPartii;
    private final LinkedList<Integer> glosyOddaneNaPoszczegolnePartie;
    private final LinkedList<Integer> glosyOddaneNaPoszczegolnychKandydatow;

    public WynikiGlosowania(LinkedList<String> listaPartii, LinkedList<Integer> glosyOddaneNaPoszczegolnePartie,
                            LinkedList<Integer> glosyOddaneNaPoszczegolnychKandydatow) {
        this.listaPartii = listaPartii;
        this.glosyOddaneNaPoszczegolnePartie = glosyOddaneNaPoszczegolnePartie;
        this.glosyOddaneNaPoszczegolnychKandydatow = glosyOddaneNaPoszczegolnychKandydatow;
    }
}
