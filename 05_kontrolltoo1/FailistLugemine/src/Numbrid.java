import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Numbrid {
    List<Integer> arvud;
    int vaikseim;
    int suurim;
    public Numbrid(List<Integer> arvud) {
        this.arvud = arvud;
        vaikseim = arvud.get(0);
        suurim = arvud.get(0);
        for (int i: arvud){
            if (vaikseim > i){
                vaikseim = i;
            }
            if (suurim < i){
                suurim = i;
            }
        }
    }
//    public void suurimVahim(List<Integer> arvud, int vaikseim, int suurim){
//        for (int i: arvud){
//            //if (vaikseim = )
//            if (vaikseim > i){
//                vaikseim = i;
//            }
//            if (suurim < i){
//                suurim = i;
//            }
//        }
//        System.out.println(suurim);
//        System.out.println(vaikseim);
//    }
    public List<Integer> newList(){

        Collections.sort(arvud);

        int kakskumendviis = arvud.get((int)Math.round(arvud.size() * 0.26));
        int viiskumend = arvud.get((int)Math.round(arvud.size() * 0.51));
        int seitsekumendviis = arvud.get((int)Math.round(arvud.size() * 0.76));

        List<Integer> newList = new ArrayList<>();
        newList.add(vaikseim);
        newList.add(kakskumendviis);
        newList.add(viiskumend);
        newList.add(seitsekumendviis);
        newList.add(suurim);
        return newList;
    }
}
