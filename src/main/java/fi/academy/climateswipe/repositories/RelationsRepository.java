package fi.academy.climateswipe.repositories;

import fi.academy.climateswipe.entities.Relations;
import fi.academy.climateswipe.entities.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelationsRepository extends CrudRepository<Relations, Integer> {
    List<Relations> findAll();
    Relations findById(int id);
    List<Relations> findAllByUser(Users user);

}
