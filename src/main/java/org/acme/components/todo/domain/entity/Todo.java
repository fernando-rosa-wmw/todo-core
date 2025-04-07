package org.acme.components.todo.domain.entity;

import java.time.LocalDate;

public class Todo {
    
    private Long id;
    private String name;
    private boolean done;
    private LocalDate limitDate;

    public Todo(String name, boolean done, LocalDate limitDate) {
        this.name = name;
        this.limitDate = limitDate;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getLimitDate() {
        return limitDate;
    }
    
    public void setLimitDate(LocalDate limitDate) {
        this.limitDate = limitDate;
    }

    public boolean isValid() {
        return this.name != null && ! this.name.isEmpty();
    }

    public static Todo createDefaultTodo(String name, LocalDate limitDate) {
        return new Todo(name, false,limitDate);
    }

    public static Todo createCheckedTodo(String name, LocalDate limitDate) {
        return new Todo(name, true,limitDate);
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", done=" + done + ", limitDate=" + limitDate + "]";
    }
    
}
