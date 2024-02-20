public class Main {
    public static void main(String[] args) {
        Info macbook = new Info("MacBook", 16, "Intel");
        Arvuti arvuti = new Arvuti(macbook, 1000, "Kristiine");
        Arvuti arvuti2 = new Arvuti(new Info("Dell", 8, "AMD"), 500, "Ulemiste");

        arvuti.muudaPoodi("Mustam2e");
        arvuti2.allahndlus(200);
        arvuti.info.muudaNimetus("Mac Pro");

        
    }
}