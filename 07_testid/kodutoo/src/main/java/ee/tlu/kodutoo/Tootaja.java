package ee.tlu.kodutoo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "tootaja")
@Entity
@NoArgsConstructor
public class Tootaja {
    @Id
    String nimi;
    String tookoht;
    int palk;
}

