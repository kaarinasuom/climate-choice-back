package fi.academy.climateswipe.Repositories;

import fi.academy.climateswipe.Entities.Tasks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TasksRepository extends CrudRepository<Tasks, Integer> {
    Tasks findById(int id);
    List<Tasks> findAll();
}