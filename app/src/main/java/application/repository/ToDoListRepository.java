package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.ToDoList;

public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {
    
}
