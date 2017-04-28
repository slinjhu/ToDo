package com.slin.todo.repository;

import com.slin.todo.domain.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
  List<ToDo> findAll();
}
