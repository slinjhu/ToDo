package com.slin.todo.repository;

import com.slin.todo.domain.ToDo;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
  Collection<ToDo> findAll();
}
