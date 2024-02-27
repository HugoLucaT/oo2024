import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("valjund.txt"));
        pw.print("Elas metsas");
        pw.println(" mutionu");
        pw.println("keset kuuski noorivanu");
        pw.close();
    }
}