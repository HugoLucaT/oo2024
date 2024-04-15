package ee.tlu.kodutoo;


// jpa moodulist parinev. Hibernate.
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@Table(name = "newtootaja") //tabeli nime panemiseks
@Entity //andmebaasipanemiseks
@NoArgsConstructor //andmebaasipanemiseks
public class Tootaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Tootajapalk tootajapalk;
    String nimi;
    int lisapalk;
}

