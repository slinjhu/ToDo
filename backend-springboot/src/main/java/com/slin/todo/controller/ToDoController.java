package com.slin.todo.controller;

import com.slin.todo.domain.ToDo;
import com.slin.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j
public class ToDoController {
  private final ToDoService service;

  @CrossOrigin
  @GetMapping("/todo")
  public List<ToDo> findAll(@RequestHeader("User-Agent") String userAgent) {
    log.info("findAll() request from " + userAgent);
    return service.findAll();
  }

  @CrossOrigin
  @PutMapping("/todo/{id}")
  public ToDo update(@RequestBody ToDo todo) {
    log.info("update(): " + todo.toString());
    return service.update(todo);
  }

  @CrossOrigin
  @PostMapping("/todo")
  public ToDo create(@RequestBody ToDo todo) {
    log.info("create(): " + todo.toString());
    return service.create(todo);
  }

  @CrossOrigin
  @DeleteMapping("/todo/{id}")
  public void delete(@PathVariable("id") long id) {
    service.delete(id);
    log.info("delete() by id: " + id);
  }
}
