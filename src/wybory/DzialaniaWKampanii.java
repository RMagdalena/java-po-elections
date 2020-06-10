package wybory;

import java.util.Arrays;
import java.util.LinkedList;

public class DzialaniaWKampanii {

    private final int[] opis;

    public DzialaniaWKampanii(int[] opis) {
        this.opis = opis;
    }

    private int cena() {
        int wynik = 0;
        if (opis != null) {
            for (int i : opis) {
                wynik += Math.abs(i);
            }
        }
        return wynik;
    }

    public int[] getOpis() {
        return opis;
    }

    public int koszt(int liczbaWyborcow) {
        return liczbaWyborcow * cena();
    }

    public void wykonaj(Okreg okreg) {
        if (okreg != null) {
            LinkedList<Wyborca> listaWyborcow = okreg.getListaWyborcow();
            if (listaWyborcow != null) {
                for (Wyborca wyborca : listaWyborcow) {
                    wyborca.zmienWagi(opis);
                }
            }
        }
    }
}
