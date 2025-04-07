package org.acme.components.todo.domain.usecase;

public interface ICreateTodo {
    
    Output execute(Input input);

    record Input(String name, String limitDate) {}
    record Output(String message) {}
}
