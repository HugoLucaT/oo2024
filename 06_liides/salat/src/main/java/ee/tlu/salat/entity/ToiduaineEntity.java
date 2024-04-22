package ee.tlu.salat.entity;


// jpa moodulist parinev. Hibernate.
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "toiduaine") //tabeli nime panemiseks
@Entity //andmebaasipanemiseks
@NoArgsConstructor //andmebaasipanemiseks
public class ToiduaineEntity {
    @Id
    private String nimetus;
    private int valk;
    private int rasv;
    private int sysivesik;

    /*public ToiduaineEntity(String nimetus, int valk, int rasv, int sysivesik) {
        this.nimetus = nimetus;
        this.valk = valk;
        this.rasv = rasv;
        this.sysivesik = sysivesik;
    }*/
}
