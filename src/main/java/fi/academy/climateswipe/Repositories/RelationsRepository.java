package fi.academy.climateswipe.Repositories;

import fi.academy.climateswipe.Entities.Relations;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelationsRepository extends CrudRepository<Relations, Integer> {
    List<Relations> findAll();
    Relations findById(int id);

}
