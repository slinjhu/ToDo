package com.slin.todo.service;

import com.slin.todo.domain.ToDo;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestToDoService {
    private final static String TITLE = "Test To Do Title.";

    @Autowired
    private ToDoService service;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void reset() {
        service.mock();
    }

    @Test
    public void testMock() {
        assertEquals(4, service.findAll().size());
    }

    @Test
    public void testCreate() {

        ToDo todo = service.create(new ToDo(TITLE));
        assertEquals(TITLE, todo.getTitle());
        assertEquals(false, todo.getDone());
        assertNotNull(todo.getId());
        assertEquals(5, service.findAll().size());
    }

    @Test
    public void testDelete() {
        for (ToDo todo : service.findAll()) {
            service.delete(todo.getId());

            exception.expect(NotFoundException.class);
            service.find(todo.getId());
        }
    }

    @Test
    public void testUpdate() {
        ToDo todo = service.findAll().get(0);
        todo.setDone(true);
        todo.setTitle(TITLE);
        ToDo todoUpdated = service.update(todo);
        assertEquals(todo.getId(), todoUpdated.getId());
        assertEquals(true, todoUpdated.getDone());
        assertEquals(TITLE, todoUpdated.getTitle());
    }

    @Test
    public void testUpdateNotExists() {
        ToDo todo = service.findAll().get(0);
        todo.setId(todo.getId() + 10);
        ToDo todoUpdated = service.update(todo);
        assertEquals("Todo not found", todoUpdated.getTitle());
    }

}
