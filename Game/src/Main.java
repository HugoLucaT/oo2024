import java.util.ArrayList;
import java.util.List;
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
        List<Tegelane> tegelased = new ArrayList<>();
        tegelased.add(mangija);
        tegelased.add(draakon);
        tegelased.add(ork);


        Ese m66k = new Ese("M66k", 10, 10, random, maailm);
        Ese haamer = new Ese("Haamer", 5, 5, random, maailm);
        Ese saabas = new Ese("Saabas", 1, 1, random, maailm);
        List<Ese> esemed = new ArrayList<>();
        /*List<Integer> numbrid;*/
        esemed.add(m66k);
        esemed.add(haamer);
        esemed.add(saabas);

        Soiduk auto = new Soiduk(2, "Auto", random, maailm);
        List<Soiduk> soidukid = new ArrayList<>();
        soidukid.add(auto);

        maailm.prindiKaart(tegelased, esemed);
        //scanner on ka klass
        Scanner scanner = new Scanner(System.in);
        String sisend = scanner.nextLine();
        mangija.liigu(sisend, maailm);


        while (!sisend.equals("end")) {
            //mangjaliigu
            maailm.prindiKaart(tegelased, esemed);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
            for (Ese e: esemed){
                if (mangija.Xkoord == e.Xkoord && mangija.Ykoord == e.Ykoord){
                    mangija.ese = e;
                    System.out.println("Korjasid ules eseme: " + e.nimetus);
                    break;
                }
            }


        }
    }



    /*private static static mainis mitte mujal int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }*/
}


