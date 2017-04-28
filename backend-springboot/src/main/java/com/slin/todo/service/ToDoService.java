package com.slin.todo.service;

import com.slin.todo.domain.ToDo;
import com.slin.todo.repository.ToDoRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j
public class ToDoService {
    private final ToDoRepository repository;

    public ToDo create(ToDo todo) {
        todo.setId(null);
        return repository.save(todo);
    }

    @SneakyThrows
    public ToDo find(long id) {
        if (repository.exists(id)) {
            return repository.findOne(id);
        } else {
            throw new NotFoundException("Id does not exist: " + id);
        }
    }

    public List<ToDo> findAll() {
        return repository.findAll();
    }

    public ToDo update(ToDo todo) {
        if (repository.exists(todo.getId())) {
            return repository.save(todo);
        } else {
            return new ToDo("Todo not found");
        }
    }

    public void delete(long id){
        repository.delete(id);
    }

    public void mock() {
        repository.deleteAll();
        repository.save(new ToDo("Refactor ToDoController", false));
        repository.save(new ToDo("Add unit tests", false));
        repository.save(new ToDo("Build todo frontend", true));
        repository.save(new ToDo("Fix bugs", false));
        log.info("mock()");
    }
}
