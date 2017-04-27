package com.slin.todo.controller;

import com.slin.todo.domain.ToDo;
import com.slin.todo.repository.ToDoRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    log.info("findAll() request from " + userAgent);
    return toDoRepository.findAll();
  }

  @CrossOrigin
  @PutMapping("/todo/{id}")
  public ToDo save(@RequestBody ToDo todo) {
    log.info("save(): " + todo.toString());
    toDoRepository.save(todo);
    return toDoRepository.findOne(todo.getId());
  }

  @CrossOrigin
  @PostMapping("/todo")
  public ToDo create(@RequestBody ToDo todo) {
    log.info("create(): " + todo.toString());
    toDoRepository.save(todo);
    return todo;
  }

  @CrossOrigin
  @GetMapping("/todo/{id}")
  public ToDo findById(@PathVariable("id") long id) {
    log.info("findById(): " + id);
    return toDoRepository.findOne(id);
  }

  @CrossOrigin
  @DeleteMapping("/todo/{id}")
  public ToDo delete(@PathVariable("id") long id) {
    ToDo todo = toDoRepository.findOne(id);
    toDoRepository.delete(id);
    log.info("delete() by id: " + id);
    return todo;
  }

  @GetMapping("/mock")
  public Collection<ToDo> mock() {
    toDoRepository.deleteAll();
    toDoRepository.save(new ToDo("Refactor ToDoController", false));
    toDoRepository.save(new ToDo("Add unit tests", false));
    toDoRepository.save(new ToDo("Build todo frontend", true));
    toDoRepository.save(new ToDo("Fix bugs", false));
    log.info("mock()");
    return toDoRepository.findAll();
  }
}
