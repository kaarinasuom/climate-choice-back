package fi.academy.climateswipe.repositories;

import fi.academy.climateswipe.entities.Users;
import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<Users, Integer> {
    Users findById(int id);

}
