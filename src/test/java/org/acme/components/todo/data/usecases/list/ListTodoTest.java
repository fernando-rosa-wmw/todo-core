package org.acme.components.todo.data.usecases.list;

import org.acme.components.todo.data.usecases.create.CreateTodo;
import org.acme.components.todo.domain.usecases.ICreateTodo;
import org.acme.components.todo.domain.usecases.IListAllTodo;
import org.acme.components.todo.infra.memory.repositories.MemoryTodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class ListTodoTest {
    
    @Inject
    MemoryTodoRepository todoRepository;

    @Test
    void testRightExecute() {
        ICreateTodo createTodo = new CreateTodo(this.todoRepository);

        IListAllTodo listTodo = new ListAllTodo(todoRepository);

        IListAllTodo.Output output = listTodo.execute(new IListAllTodo.Input());
        Assertions.assertEquals(0, output.todos().size());

        createTodo.execute(new ICreateTodo.Input("Fazer cafe", "2025-04-08"));

        IListAllTodo.Output secondOutput = listTodo.execute(new IListAllTodo.Input());
        Assertions.assertEquals(1, secondOutput.todos().size());
    }

}
