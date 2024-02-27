import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> arvud = new ArrayList<>();
        arvud.add(14.0);
        arvud.add(12.0);
        arvud.add(4.5);
        arvud.add(30.0);
        List<Double> libisevKesk = arvutaLibisevKesmine(arvud);
        System.out.println(libisevKesk);

        Keskmine keskmine1 = new Keskmine(arvud);
        List<Double> libisevKeskmine2 = keskmine1.saaArvudKeskmised();
        keskmine1.lisaArv(10.0);
        System.out.println(libisevKeskmine2);
    }
    private static double arvutaAritmeetilineKeskmine(double arv1, double arv2, double arv3){
        return (arv1 + arv2 + arv3) / 3;
    }
    private static List<Double> arvutaLibisevKesmine(List<Double> arvud){
        List<Double> arvudKeskmised = new ArrayList<>();
        for (int i = 0; i < arvud.size() - 2; i++) {
            double libisevKeskmine = (arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2)) / 3;
            arvudKeskmised.add(libisevKeskmine);
        }
        return arvudKeskmised;
    }
}