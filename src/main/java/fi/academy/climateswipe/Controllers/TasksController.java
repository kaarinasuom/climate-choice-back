package fi.academy.climateswipe.Controllers;
import fi.academy.climateswipe.Entities.Tasks;
import fi.academy.climateswipe.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Tasks")
public class TasksController {
    private TasksRepository TasksRepository;

    @Autowired
    public TasksController(
            TasksRepository TasksRepository) {
        this.TasksRepository = TasksRepository;
    }

    @GetMapping("/Task/{id}")
    public Optional<Tasks> show(@PathVariable Integer id) {
        return TasksRepository.findById(id);
    }

    @GetMapping("/")
    public List<Tasks> contact() {
        return TasksRepository.findAll();
    }

}
