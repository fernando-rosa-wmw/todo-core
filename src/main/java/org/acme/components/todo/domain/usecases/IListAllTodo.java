package org.acme.components.todo.domain.usecases;

import java.util.List;

import org.acme.components.todo.domain.entity.Todo;

public interface IListAllTodo {
    
    Output execute(Input Input);

    public record Input() {}
    public record Output(String message, List<Todo> todos) {}
}
