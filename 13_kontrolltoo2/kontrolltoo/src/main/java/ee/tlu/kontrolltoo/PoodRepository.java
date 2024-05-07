package ee.tlu.kontrolltoo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoodRepository extends JpaRepository<Pood, Long> {

    Pood findFirstByKulastanudNotNullOrderByKulastanudDesc();

    List<Pood> findByKulastanudNotNullOrderByKulastanudDesc();

    List<Pood> findByAvatudLessThanEqualAndSuletudGreaterThan(int avatud, int suletud);


}
