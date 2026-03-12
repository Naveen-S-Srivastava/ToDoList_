package com.techgamenium.todolist.Controller;



import com.techgamenium.todolist.Model.Task;
import com.techgamenium.todolist.Repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return repository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updated){

        Task task = repository.findById(id).orElseThrow();

        task.setTitle(updated.getTitle());
        task.setDueDate(updated.getDueDate());
        task.setCompleted(updated.isCompleted());

        return repository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        repository.deleteById(id);
    }

}