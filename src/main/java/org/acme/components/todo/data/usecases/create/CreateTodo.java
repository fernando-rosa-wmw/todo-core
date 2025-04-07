package org.acme.components.todo.data.usecases.create;

import java.time.LocalDate;
import java.util.Date;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.domain.usecase.ICreateTodo;
import org.acme.shared.helper.DateHelper;

public class CreateTodo implements ICreateTodo {

    private final ITodoRepository todoRepository;
   
    public CreateTodo(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Output execute(Input input) {

        LocalDate limitDate = DateHelper.convertStringToDate(input.limitDate());

        if (limitDate == null) {
            return new Output("Data com formato Incorreto");
        }

        Todo todo = Todo.createDefaultTodo(input.name(), limitDate);

        if (! todo.isValid()) {
            return new Output("Todo recebido é invalido");
        }
        
        boolean isCreated = this.todoRepository.insertTodo(todo);

        if (isCreated) {
            return new Output("Criado com sucesso");
        } else {
            return new Output("Erro ao criar");
        }
    }
    
}
