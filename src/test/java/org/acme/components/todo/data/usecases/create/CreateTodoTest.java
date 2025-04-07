package org.acme.components.todo.data.usecases.create;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.domain.usecase.ICreateTodo;
import org.acme.components.todo.domain.usecase.ICreateTodo.Input;
import org.acme.components.todo.domain.usecase.ICreateTodo.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class CreateTodoTest { 

    private final ITodoRepository todoRepository = new ITodoRepository() {

        @Override
        public Boolean insertTodo(Todo todo) {
            return true;
        }
        
    };

    @Test
    void CorrectTestExecute() {
        ICreateTodo createTodo = new CreateTodo(this.todoRepository);

        Output output = createTodo.execute(new Input("Grupo de estudos", "2025-05-20"));

        Assertions.assertEquals("Criado com sucesso", output.message());
    }

    @Test
    void WrongDateTestExecute() {
        ICreateTodo createTodo = new CreateTodo(this.todoRepository);
        Assertions.assertThrows(Exception.class, () -> createTodo.execute(new Input("Grupo de estudos", "2025-05-2200")));
    }
}
