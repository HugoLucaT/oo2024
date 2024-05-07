package ee.tlu.kontrolltoo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class KaubandusKeskus {
    @Id
    String nimetus;
}
