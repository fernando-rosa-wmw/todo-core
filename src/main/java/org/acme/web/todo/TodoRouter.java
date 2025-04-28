package org.acme.web.todo;

import java.util.List;

import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.infra.mongo.repositories.MongoTodoRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/todo")
public class TodoRouter {
    
    private final TodoController todoController;

    @Inject
    public TodoRouter(MongoTodoRepository mongoTodoRepository) {
        this.todoController = new TodoController(mongoTodoRepository);
    }

    @Path("/create")
    @POST
    public String createTodo(CreateTodoInput body) {
        return this.todoController.createTodo(body.name(), body.limitDate());
    }

    public record CreateTodoInput(
        String name, 
        String limitDate
    ) {}

    @Path("/listAll")
    @POST
    public List<Todo> listAll() {
        return this.todoController.listAll();
    }
}
