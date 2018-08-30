package fi.academy.climateswipe.repositories;

import fi.academy.climateswipe.entities.Tasks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;


public interface TasksRepository extends CrudRepository<Tasks, Integer> {
    Tasks findById(int id);
    List<Tasks> findAll();

    @Query("SELECT id FROM Tasks")
    List<Integer> findAllIds();
}