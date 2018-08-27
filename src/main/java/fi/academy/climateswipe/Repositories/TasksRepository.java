package fi.academy.climateswipe.repositories;

import fi.academy.climateswipe.entities.Tasks;
import org.springframework.data.repository.CrudRepository;



public interface TasksRepository extends CrudRepository<Tasks, Integer> {

}