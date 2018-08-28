package fi.academy.climateswipe.repositories;

import fi.academy.climateswipe.entities.Tasks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TasksRepository extends CrudRepository<Tasks, Integer> {
    Tasks findById(int id);
    List<Tasks> findAll();
}