package org.acme.components.todo.data.repositories;

import org.acme.components.todo.domain.entity.Todo;

public interface ITodoRepository {
    Boolean insertTodo(Todo todo);
}