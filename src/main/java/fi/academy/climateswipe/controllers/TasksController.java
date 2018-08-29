package fi.academy.climateswipe.controllers;
import fi.academy.climateswipe.entities.Tasks;
import fi.academy.climateswipe.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tasks")
public class TasksController {
    private TasksRepository tasksRepository;

    @Autowired
    public TasksController(
            TasksRepository TasksRepository) {
        this.tasksRepository = TasksRepository;
    }

    @GetMapping("/{id}")
    public Optional<Tasks> show(@PathVariable Integer id) {
        return tasksRepository.findById(id);
    }


    @GetMapping
    public Iterable<Tasks> contact() {
        return tasksRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Integer id) {
        tasksRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> addRelation(@RequestBody Tasks tasks) {
        tasksRepository.save(tasks);
        int id = tasks.getId();
        URI location = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("/tasks/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@RequestBody Tasks newTasks, @PathVariable Integer id) {
        Optional<Tasks> tasksOptional = tasksRepository.findById(id);
        if (!tasksOptional.isPresent())
            return ResponseEntity.notFound().build();
        newTasks.setId(id);
        tasksRepository.save(newTasks);
        return ResponseEntity.noContent().build();
    }

}
