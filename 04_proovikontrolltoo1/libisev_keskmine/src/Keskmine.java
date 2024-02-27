import java.util.ArrayList;
import java.util.List;

public class Keskmine {
    List<Double> arvud = new ArrayList<>();
    List<Double> arvudKeskmised = new ArrayList<>();

    public Keskmine(List<Double> arvudAlguses) {
        arvud = arvudAlguses;
        arvutaLibisevKesmine();
    }

    private List<Double> arvutaLibisevKesmine(){
        for (int i = 0; i < arvud.size() - 2; i++) {
            double libisevKeskmine = (arvud.get(i) + arvud.get(i + 1) + arvud.get(i + 2)) / 3;
            arvudKeskmised.add(libisevKeskmine);
        }
        return arvudKeskmised;
    }

    public List<Double> saaArvudKeskmised(){
        return arvudKeskmised;
    }
    public void lisaArv(Double arv){
        Double viimane = arvud.get(arvud.size() - 1);
        Double eelViimane = arvud.get(arvud.size() - 2);
        arvud.add(arv);
        Double keskmine = (viimane + eelViimane + arv) / 3;
        arvudKeskmised.add(keskmine);
    }


}
