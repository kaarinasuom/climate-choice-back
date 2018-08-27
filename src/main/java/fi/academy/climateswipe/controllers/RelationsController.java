package fi.academy.climateswipe.controllers;


import fi.academy.climateswipe.entities.Relations;
import fi.academy.climateswipe.repositories.RelationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relations")
public class RelationsController {
    private RelationsRepository relationsRepository;

    @Autowired
    public RelationsController(RelationsRepository relationsRepository) {
        this.relationsRepository = relationsRepository;
    }

    @GetMapping
    public Iterable<Relations> getAll() { return relationsRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional<Relations> getOne(@PathVariable int id) { return relationsRepository.findById(id); }

}
