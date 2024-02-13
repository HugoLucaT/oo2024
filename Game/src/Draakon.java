import java.util.Random;

public class Draakon {

    int Xkoord;
    int Ykoord;
    char Symbol = 'D';

    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        Xkoord = saaKoordinaat(random, kaardiLaius);
        Ykoord = saaKoordinaat(random, kaardiKorgus);
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
}
