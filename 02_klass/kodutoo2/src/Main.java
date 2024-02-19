public class Main {
    public static void main(String[] args) {
        //Main + klass
        //2 omadust
        //2 funktsiooni
        //2 valjakutseet
        /*Kasutaja kasutaja = new Kasutaja("Hugo", true, 30, 'h', 3.5);
        Kasutaja kasutaja2 = new Kasutaja("b", false, 10, 'b', 14.5);
        kasutaja.muudaAktiivne();
        double kasutaja2raha =  kasutaja2.lisaRaha(40);*/

        Temp jaanuar = new Temp(2.2, true, 2);
        Temp juuli = new Temp(0, false, 80);
        juuli.tempVahetus();
        System.out.println("Jaanuari temperatuur: " + jaanuar.temp + ", " + jaanuar.sademed());
        System.out.println("Juuli temperatuur: " + juuli.temp + ", " + juuli.sademed());
    }
}