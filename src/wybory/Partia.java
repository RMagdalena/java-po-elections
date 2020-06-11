package wybory;

public class Partia {
    private final String nazwaPartii;
    private int budzet;
    private final Strategia strategiaPartii;

    private int uzyskaneGlosy;
    private int uzyskaneMandaty;

    public Partia(String nazwaPartii, int budzet, Strategia strategiaPartii) {
        this.nazwaPartii = nazwaPartii;
        this.budzet = budzet;
        this.strategiaPartii = strategiaPartii;
        this.uzyskaneGlosy = 0;
        this.uzyskaneMandaty = 0;
    }

    public String getNazwaPartii() {
        return nazwaPartii;
    }

    public int getUzyskaneGlosy() {
        return uzyskaneGlosy;
    }

    public void dodajGlosy() {
        uzyskaneGlosy++;
    }

    public void dodajMandaty(int uzyskaneMandaty) {
        this.uzyskaneMandaty += uzyskaneMandaty;
    }

    public void zaplacZaDzialanie(int koszt) {
        this.budzet -= koszt;
    }

    public void kampania(Okreg[] okregi, DzialaniaWKampanii[] dzialaniaWKampanii) {
        boolean czyWykonanoDzialanie = true;
        while (czyWykonanoDzialanie) {
            czyWykonanoDzialanie = strategiaPartii.wykonajDzialanie(dzialaniaWKampanii, budzet, okregi, this);
        }
    }

    public StringBuilder wypiszMandaty() {
        StringBuilder wynik = new StringBuilder();
        wynik.append(nazwaPartii + " " + uzyskaneMandaty + "\n");
        return wynik;
    }
}
