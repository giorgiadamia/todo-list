package com.example.todolist.model;

import com.example.todolist.entity.ToDoEntity;

public class ToDo {
    private Long id;
    private String title;
    private Boolean isCompleted;

    public static ToDo toModel(ToDoEntity toDoEntity) {
        ToDo model = new ToDo();
        model.setId(toDoEntity.getId());
        model.setTitle(toDoEntity.getTitle());
        model.setCompleted(toDoEntity.getCompleted());
        return model;
    }

    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
