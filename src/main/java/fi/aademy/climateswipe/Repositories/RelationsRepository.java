package fi.aademy.climateswipe.Repositories;

import fi.aademy.climateswipe.Entities.Relations;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelationsRepository extends CrudRepository<Relations, Integer> {
    List<Relations> findAll();
    Relations findById(int id);

}
