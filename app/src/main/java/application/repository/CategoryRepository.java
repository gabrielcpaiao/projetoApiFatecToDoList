package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    
}
