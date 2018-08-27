package fi.academy.climateswipe.Repositories;

import fi.academy.climateswipe.Entities.Users;
import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<Users, Integer> {

}
