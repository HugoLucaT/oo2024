import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lugemine.txt"));
        List<Integer> arvud = new ArrayList<>();
//        arvud.add(4);
//        arvud.add(6);
//        arvud.add(7);
//        arvud.add(2);
//        arvud.add(3);
//        arvud.add(14);
//        arvud.add(71);
//        arvud.add(25);
//        arvud.add(31);
//        arvud.add(17);
        String rida = br.readLine();
        PrintWriter pw2 = new PrintWriter(new FileWriter("2.txt"));
        PrintWriter pw3 = new PrintWriter(new FileWriter("3.txt"));
        PrintWriter pw5 = new PrintWriter(new FileWriter("5.txt"));
        while (rida != null){
            int nr = Integer.parseInt(rida);
            //System.out.println(nr);
            arvud.add(nr);
            //String[] s6nad = rida.split(" ");
            //System.out.println(Arrays.toString(s6nad));
            //rida = br.readLine();
            if (nr % 2 == 0){
                pw2.println(nr);
            }
            if (nr % 3 == 0){
                pw3.println(nr);
            }
            if (nr % 5 == 0){
                pw5.println(nr);
            }
            rida = br.readLine();
        }
        pw2.close();
        pw3.close();
        pw5.close();
        Numbrid test = new Numbrid(arvud);
        System.out.println(test.suurim);
        System.out.println(test.vaikseim);
        arvud = test.newList();
        System.out.println(arvud);
    }
}