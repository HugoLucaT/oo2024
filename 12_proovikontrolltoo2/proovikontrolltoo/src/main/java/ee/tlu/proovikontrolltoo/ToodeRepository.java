package ee.tlu.proovikontrolltoo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToodeRepository extends JpaRepository<Toode, Long> {


    List<Toode> findByHindBetween(double hindStart, double hindEnd);

    Toode findFirstByHindNotNullOrderByHindDesc();

    List<Toode> findByKategooria_Id(Long id);

    List<Toode> findByNimiContains(String nimi);

    List<Toode> findByNimiStartsWith(String nimi);
}
