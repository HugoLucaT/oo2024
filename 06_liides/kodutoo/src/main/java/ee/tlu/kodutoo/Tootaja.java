package ee.tlu.kodutoo;


// jpa moodulist parinev. Hibernate.
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*@Getter
public class Tootaja {
    String nimi;
    String tookoht;
    int palk;

    public Tootaja(String nimi, String tookoht, int palk) {
        this.nimi = nimi;
        this.tookoht = tookoht;
        this.palk = palk;
    }
}*/


@Getter
@AllArgsConstructor
@Table(name = "tootaja") //tabeli nime panemiseks
@Entity //andmebaasipanemiseks
@NoArgsConstructor //andmebaasipanemiseks
public class Tootaja {
    @Id
    String nimi;
    String tookoht;
    int palk;
}

