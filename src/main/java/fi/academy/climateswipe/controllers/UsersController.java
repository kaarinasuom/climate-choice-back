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
@CrossOrigin(origins= "http://localhost:3000")
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
    public Users show(@PathVariable int id) {
        return usersRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable int id) {
        usersRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        usersRepository.save(user);
        int id = user.getId();
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("/users/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

//    @PutMapping("/{id}")
//    public void  update(@RequestBody Users newInfo, @PathVariable int id) {
//        Users user = usersRepository.findById(id);
//        user.set;
//        usersRepository.save(user);
//    }

}
