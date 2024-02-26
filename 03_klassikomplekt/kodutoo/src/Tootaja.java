public class Tootaja {
    String nimi;
    String telefon;
    int vanus;
    Tookoht tookoht;

    public Tootaja(Tookoht tookoht, String nimi, String telefon, int vanus) {
        this.tookoht = tookoht;
        this.nimi = nimi;
        this.telefon = telefon;
        this.vanus = vanus;
    }

    public void sunnipaev(){
        vanus += 1;
    }

    public void uusTelefon(String uusTelefon){
        telefon = uusTelefon;
    }
}
