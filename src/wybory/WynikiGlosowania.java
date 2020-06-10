package wybory;

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
}
