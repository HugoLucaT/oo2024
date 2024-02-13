public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;

    public Maailm (int korgus, int laius){
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }

    public void prindiKaart(Mangija mangija, Draakon draakon, Ork ork) {
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

                    if (x == mangija.Xkoord && y == mangija.Ykoord) {
                        //System.out.print(mangijaSymbol);
                        symbol = mangija.Symbol;
                    } else if (x == draakon.Xkoord && y == draakon.Ykoord) {
                        symbol = draakon.Symbol;
                    } else if (x == ork.Xkoord && y == ork.Ykoord) {
                        symbol = ork.Symbol;
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
}
