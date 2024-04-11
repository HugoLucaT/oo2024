package ee.tlu.salat;

//koosneb toiduaines ja temaga seotud kogusest toidu sees
//Klassikomplekt -> Kartul+omadused ja mitu grammi

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Entity //andmebaasipanemiseks
@NoArgsConstructor //andmebaasipanemiseks
public class Toidukomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne //@ManyToMany on listidele
    ToiduaineEntity toiduaine;
    int kogus;
}
