package fi.academy.climateswipe.controllers;


import fi.academy.climateswipe.entities.Users;
import fi.academy.climateswipe.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins= "https://climate-choice-2019.herokuapp.com")
@RequestMapping("/users")
public class UsersController {

    private UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public Iterable<Users> contact() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Users show(@PathVariable String id) {
        return usersRepository.findByUid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id) {
        usersRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        Users newUser = user;
        newUser.setUid(user.getUid());
        usersRepository.save(user);
        String id = user.getUid();
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("climate-choice-2019.herokuapp.com")
                .path("/users/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
