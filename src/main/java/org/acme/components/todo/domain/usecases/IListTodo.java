package org.acme.components.todo.domain.usecases;

import java.util.List;

import org.acme.components.todo.domain.entity.Todo;

public interface IListTodo {
    
    Output execute(Input input);

    public record Input(

    ) {}
    
    public record Output(
        List<Todo> todos,
        String message
    ) {}
}
