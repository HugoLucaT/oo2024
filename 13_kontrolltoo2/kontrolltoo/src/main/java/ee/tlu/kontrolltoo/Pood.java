package ee.tlu.kontrolltoo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nimetus;
    int avatud;
    int suletud;
    int kulastanud;
    @ManyToOne
    KaubandusKeskus kaubandusKeskus;
}
