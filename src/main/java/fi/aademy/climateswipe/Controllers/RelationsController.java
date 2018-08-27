package fi.aademy.climateswipe.Controllers;


import fi.aademy.climateswipe.Entities.Relations;
import fi.aademy.climateswipe.Repositories.RelationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relations")
public class RelationsController {
    private RelationsRepository relationsRepository;

    @Autowired
    public RelationsController(RelationsRepository relationsRepository) {
        this.relationsRepository = relationsRepository;
    }

    @GetMapping
    public List<Relations> getAll() { return relationsRepository.findAll(); }

    @GetMapping("/{id}")
    public Relations getOne(@PathVariable int id) { return relationsRepository.findById(id); }

}
