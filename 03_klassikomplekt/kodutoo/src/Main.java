public class Main {
    public static void main(String[] args) {
        //Info macbook = new Info("MacBook", 16, "Intel");
        //Arvuti arvuti = new Arvuti(macbook, 1000, "Kristiine");
        //Arvuti arvuti2 = new Arvuti(new Info("Dell", 8, "AMD"), 500, "Ulemiste");

        //arvuti.muudaPoodi("Mustam2e");
        //arvuti2.allahndlus(200);
        //arvuti.info.muudaNimetus("Mac Pro");

        //+ soiduk gameis

        Tookoht raamatupidaja = new Tookoht("Raamatupidaja", 2000);
        Tootaja Tamm = new Tootaja(raamatupidaja, "A. Tamm", "+372 55556666", 30);
        Tootaja Kask = new Tootaja(raamatupidaja, "T. Kask", "+372 55000000", 60);

        Tamm.uusTelefon("+372 54545500");
        Kask.sunnipaev();
        raamatupidaja.uusPalk(2200);
    }
}