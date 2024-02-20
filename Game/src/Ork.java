import java.util.Random;

public class Ork extends Tegelane implements JuhuslikKoordinaat{
    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        this.Xkoord = saaKoordinaat(random, kaardiLaius);
        this.Ykoord = saaKoordinaat(random, kaardiKorgus);
        this.Symbol = 'o';
    }

    public int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
}