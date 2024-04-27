package ee.tlu.proovikontrolltoo;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Toode {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nimi;
    double hind;
    boolean aktiivne;
    @ManyToOne
    private Kategooria kategooria;
}
