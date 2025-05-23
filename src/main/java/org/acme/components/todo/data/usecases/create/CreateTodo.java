package org.acme.components.todo.data.usecases.create;

import java.time.LocalDate;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.domain.usecases.ICreateTodo;

public class CreateTodo implements ICreateTodo {

    private final ITodoRepository todoRepository;    

    public CreateTodo(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Output execute(Input input) {
        LocalDate limitDate = LocalDate.parse(input.limitDate());

        Todo todo = Todo.createDefaultTodo(input.name(), limitDate);

        if (! todo.isValid()) {
            return new Output("Todo invalido", todo);
        }

        Todo createdTodo = this.todoRepository.insertTodo(todo);

        if (createdTodo.isCorrectlyInserted()) {
            return new Output("Criado Corretamente - Id " + createdTodo.getId(), createdTodo);
        } else {
            return new Output("Não foi inserido corretamento", todo);
        }
    }
    
}
