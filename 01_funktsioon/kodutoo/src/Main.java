import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //kodus 3 funktsiooni, milles on kasutatud 4 erinevat tüüpi:
        //String, int, char, void, long, boolean, float

        // igast funktsiooniks 2 erineva sisendiga väljakutset

        double kogumaksumus = arvutaTaksoMaksumus(3);
        String hinnang = tempCheck(2.2);
        prindiRuut(7);
    }
    private static double arvutaTaksoMaksumus(int kaart) {
        return 3 + 0.9*kaart;
    }
    private static String tempCheck(double temp) {
        if (temp < 0) {
            return "Vesi on jääs";
        } else {
            return "On vesi";
        }
    }

    private static void prindiRuut(int nr) {
        System.out.println(nr * nr);
    }
}