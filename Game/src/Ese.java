import java.util.Random;

public class Ese {
    String nimetus;

    double tugevus;

    int kasutuskorrad;

    boolean aktiivne;
    int Xkoord;
    int Ykoord;
    char symbol;

    public Ese(String nimetus, double tugevus, int kasutuskorrad, Random random, Maailm maailm) {
        this.nimetus = nimetus;
        this.tugevus = tugevus;
        this.kasutuskorrad = kasutuskorrad;
        this.aktiivne = true;
        this.Xkoord = saaKoordinaat(random, maailm.kaardiLaius);
        this.Ykoord = saaKoordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'I';
    }

    public void hit(){
        System.out.println("L6id vastast");
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
}
