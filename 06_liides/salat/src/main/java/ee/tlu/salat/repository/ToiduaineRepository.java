package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduaineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {
    // siia saab kirjutada custom repository kaske

    List<ToiduaineEntity> findAllByValkGreaterThan(int valk);

    List<ToiduaineEntity> findAllBySysivesikBetween(int min, int max);
}
