import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //saab enda sisse terve hunniku funktsioone ja muutujaid
        Random random = new Random();

        Maailm maailm = new Maailm(5, 10);

        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius);

        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);

        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);

        maailm.prindiKaart(mangija, draakon, ork);
        //scanner on ka klass
        Scanner scanner = new Scanner(System.in);
        String sisend = scanner.nextLine();
        mangija.liigu(sisend, maailm);


        while (!sisend.equals("end")) {
            //mangjaliigu
            maailm.prindiKaart(mangija, draakon, ork);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
        }
    }



    /*private static static mainis mitte mujal int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }*/
}


