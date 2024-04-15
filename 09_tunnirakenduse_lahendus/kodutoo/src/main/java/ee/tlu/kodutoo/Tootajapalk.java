package ee.tlu.kodutoo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "tookoht") //tabeli nime panemiseks
@Entity //andmebaasipanemiseks
@NoArgsConstructor //andmebaasipanemiseks
public class Tootajapalk {
    @Id
    String tookoht;
    int baaspalk;
}
