package fi.academy.climateswipe.controllers;


import fi.academy.climateswipe.entities.Relations;
import fi.academy.climateswipe.entities.Users;
import fi.academy.climateswipe.repositories.RelationsRepository;
import fi.academy.climateswipe.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.management.relation.Relation;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relations")
public class RelationsController {
    private RelationsRepository relationsRepository;
    private UsersRepository usersRepository;

    @Autowired
    public RelationsController(RelationsRepository relationsRepository, UsersRepository usersRepository) {
        this.relationsRepository = relationsRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<Relations> getAll() {
        return relationsRepository.findAll(); }

    @GetMapping("/{id}")
    public Relations getOne(@PathVariable int id) { return relationsRepository.findById(id);
    }

    @GetMapping("user/{id}")
    public List<Relations> getAllRelations(@PathVariable String id) {
        Users user = usersRepository.findByUid(id);
        return relationsRepository.findAllByUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable int id) {
        relationsRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> addRelation(@RequestBody Relations relations) {
        relationsRepository.save(relations);
        int id = relations.getId();
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .path("/relations/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public void  update(@RequestBody Relations newRelations, @PathVariable int id) {
        Relations relations = relationsRepository.findById(id);
        relations.setChoice(newRelations.getChoice());
        relationsRepository.save(relations);
    }
}
