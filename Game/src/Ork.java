import java.util.Random;

public class Ork {

    int Xkoord;
    int Ykoord;
    char Symbol = 'o';
    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        Xkoord = saaKoordinaat(random, kaardiLaius);
        Ykoord = saaKoordinaat(random, kaardiKorgus);
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
}