import java.util.Random;

public class Draakon extends Tegelane implements JuhuslikKoordinaat{
    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        this.Xkoord = saaKoordinaat(random, kaardiLaius);
        this.Ykoord = saaKoordinaat(random, kaardiKorgus);
        this.Symbol = 'D';
    }

    public int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
}
