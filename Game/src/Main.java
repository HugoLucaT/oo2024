import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int kaardiKorgus = 5;
        int kaardiLaius = 10;

        int draakonX = saaKoordinaat(random, kaardiLaius);
        int draakonY = saaKoordinaat(random, kaardiKorgus);
        char draakonSymbol = '&';

        int mangijaX = saaKoordinaat(random, kaardiLaius);
        int mangijaY = saaKoordinaat(random, kaardiKorgus);
        char mangjaSymbol = 'x';

        int orkX = saaKoordinaat(random, kaardiLaius);
        int orkY = saaKoordinaat(random, kaardiKorgus);
        char orkSymbol = 'o';

        prindiKaart(kaardiKorgus, kaardiLaius, mangijaX, mangijaY, mangjaSymbol, draakonX, draakonY, draakonSymbol, orkX, orkY, orkSymbol);
        Scanner scanner = new Scanner(System.in);
        String sisend = scanner.nextLine();


        while (!sisend.equals("end")) {
            switch (sisend) {
                case "w" -> mangijaY--;
                case "s" -> mangijaY++;
                case "a" -> mangijaX--;
                case "d" -> mangijaX++;
            }
            prindiKaart(kaardiKorgus, kaardiLaius, mangijaX, mangijaY, mangjaSymbol, draakonX, draakonY, draakonSymbol, orkX, orkY, orkSymbol);
            sisend = scanner.nextLine();
        }
    }

    private static void prindiKaart(int kaardiKorgus, int kaardiLaius, int mangijaX, int mangijaY, char mangjaSymbol, int draakonX, int draakonY, char draakonSymbol, int orkX, int orkY, char orkSymbol) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus - 1) {
                    //System.out.print('-');
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius - 1) {
                    //System.out.print('|');
                    symbol = '|';
                } else {
                    if (x == mangijaX && y == mangijaY) {
                        //System.out.print(mangijaSymbol);
                        symbol = mangjaSymbol;
                    } else if (x == draakonX && y == draakonY) {
                        symbol = draakonSymbol;
                    } else if (x == orkX && y == orkY) {
                        symbol = orkSymbol;
                    } else {
                        //System.out.print(' ');
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart-1);
    }
}


