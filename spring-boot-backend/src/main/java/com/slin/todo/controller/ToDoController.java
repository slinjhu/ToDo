package com.slin.todo.controller;

import com.slin.todo.domain.ToDo;
import com.slin.todo.repository.ToDoRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j
public class ToDoController {
  private final ToDoRepository toDoRepository;

  @CrossOrigin
  @GetMapping("/todo")
  public Collection<ToDo> findAll(@RequestHeader("User-Agent") String userAgent) {
    log.info("findAll() request from: " + userAgent);
    return toDoRepository.findAll();
  }

  @CrossOrigin
  @PutMapping("/todo/{id}")
  public void save(@RequestBody ToDo todo) {
    toDoRepository.save(todo);
    log.info("save(): " + todo.toString());
  }

  @GetMapping("/mock")
  public void mock() {
    toDoRepository.save(new ToDo("Refactor ToDoController", false));
    toDoRepository.save(new ToDo("Add unit tests", false));
    toDoRepository.save(new ToDo("Development todo frontend", true));
    toDoRepository.save(new ToDo("Fix bugs", false));
  }
}
