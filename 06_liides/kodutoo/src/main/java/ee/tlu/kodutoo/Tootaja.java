package ee.tlu.kodutoo;

import lombok.Getter;

@Getter
public class Tootaja {
    String nimi;
    String tookoht;
    int palk;

    public Tootaja(String nimi, String tookoht, int palk) {
        this.nimi = nimi;
        this.tookoht = tookoht;
        this.palk = palk;
    }
}

