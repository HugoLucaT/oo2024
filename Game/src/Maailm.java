import java.util.List;

public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;

    public Maailm (int korgus, int laius){
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }

    public void prindiKaart(List<Tegelane> tegelased, List<Ese> esemed) {
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
                    symbol = ' ';
                    for (Ese e : esemed){
                        if (e.Xkoord == x && e.Ykoord == y){
                            symbol = e.symbol;
                        }
                    }//System.out.print(' ');
                    for (Tegelane t : tegelased){
                        if (t.Xkoord == x && t.Ykoord == y){
                            symbol = t.Symbol;
                        }
                    }

                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
