package ee.tlu.kodutoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TootajaRepository extends JpaRepository<Tootaja, String> {

}
