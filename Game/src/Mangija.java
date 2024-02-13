import java.util.Random;

public class Mangija {
    int Xkoord;
    int Ykoord;
    char Symbol;
    Suund suund;

    public Mangija(Random random, int kaardiKorgus, int kaardiLaius) {
        Xkoord = saaKoordinaat(random, kaardiLaius);
        Ykoord = saaKoordinaat(random, kaardiKorgus);
        Symbol = 'x';
        suund = Suund.YLES;
    }

    public void liigu(String sisend, Maailm maailm){
        switch (sisend) {
            case "w" -> suund = Suund.YLES;
            case "s" -> suund = Suund.ALLA;
            case "a" -> suund = Suund.VASAKULE;
            case "d" -> suund = Suund.PAREMALE;
        } //switch
        switch (suund) {
            case YLES -> {
                if (Ykoord > 1) Ykoord--;
            }
            case ALLA -> {
                if (Ykoord < maailm.kaardiKorgus - 2)Ykoord++;
            }
            case VASAKULE -> {
                if (Xkoord > 1) Xkoord--;
            }
            case PAREMALE -> {
                if (Xkoord < maailm.kaardiLaius - 2) Xkoord++;
            }
        }
    } //liigu()
    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
} //mangjia
