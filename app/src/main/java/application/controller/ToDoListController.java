package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import application.model.ToDoList;
import application.repository.ToDoListRepository;
// import application.repository.;
// import application.repository.;

@RestController
@RequestMapping("/toDo")
public class ToDoListController {
    
    @Autowired
    private ToDoListRepository toDoListRepository;

    @GetMapping
    public Iterable<ToDoList> getAllToDos() {
        return toDoListRepository.findAll();
    }

    @GetMapping("/{id}")
    public ToDoList getToDoById(@PathVariable Long id) {
        return toDoListRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ToDoList createToDo(@RequestBody ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @PutMapping("/{id}")
    public ToDoList updateToDo(@PathVariable Long id, @RequestBody ToDoList toDoListDetails) {
        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow();
        toDoList.setTask(toDoListDetails.getTask());
        toDoList.setDate(toDoListDetails.getDate());
        toDoList.setId(toDoListDetails.getId());
        return toDoListRepository.save(toDoList);

    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id) {
        toDoListRepository.deleteById(id);
    }
}
