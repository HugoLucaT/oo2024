import java.util.Random;

public class Soiduk {
    int kiirus;
    String nimetus;
    int Ykoord;
    int Xkoord;
    int symbol;

    public Soiduk(int kiirus, String nimetus, Random random, Maailm maailm) {
        this.kiirus = kiirus;
        this.nimetus = nimetus;
        this.symbol = 'S';
        this.Xkoord = saaKoordinaat(random, maailm.kaardiLaius);
        this.Ykoord = saaKoordinaat(random, maailm.kaardiKorgus);
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
}
