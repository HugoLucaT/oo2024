package ee.tlu.kodutoo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Tootaja, String> {
}
