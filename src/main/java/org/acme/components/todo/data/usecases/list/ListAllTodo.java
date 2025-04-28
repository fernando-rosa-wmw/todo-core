package org.acme.components.todo.data.usecases.list;

import java.util.Collections;
import java.util.List;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.domain.usecases.IListAllTodo;

public class ListAllTodo implements IListAllTodo {

    private final ITodoRepository todoRepository;

    public ListAllTodo(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Output execute(Input Input) {
        List<Todo> todos = this.todoRepository.getAll();

        if (todos.isEmpty()) {
            return new Output("Nehum todo encontrados", Collections.emptyList());
        }

        return new Output("To-dos encontrados", todos);
    } 
}
