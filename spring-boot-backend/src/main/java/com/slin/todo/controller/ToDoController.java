package com.slin.todo.controller;

import com.slin.todo.domain.ToDo;
import com.slin.todo.repository.ToDoRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ToDoController {
  private final ToDoRepository toDoRepository;

  @GetMapping("/todo")
  public Collection<ToDo> index() {
    return toDoRepository.findAll();
  }
}
