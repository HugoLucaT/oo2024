import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //kodus 3 funktsiooni, milles on kasutatud 4 erinevat tüüpi:
        //String, int, char, void, long, boolean, float

        // igast funktsiooniks 2 erineva sisendiga väljakutset

        double toenaosus1 = arvutaProtsent(3, 5);
        double toenaosus2 = arvutaProtsent(9, 14);
        boolean positiivneNumber1 = numCheck(2.2);
        boolean positiivneNumber2 = numCheck(-3.1);
        prindiRuut(7);
        prindiRuut(16);
        System.out.println(toenaosus1);
        System.out.println(toenaosus2);
        System.out.println(positiivneNumber1);
        System.out.println(positiivneNumber2);
    }
    private static double arvutaProtsent(int edukus, int kogu) {
        return ((double)edukus / kogu);
    }
    private static boolean numCheck(double nr) {
        if (nr < 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void prindiRuut(int nr) {
        System.out.println(nr * nr);
    }
}