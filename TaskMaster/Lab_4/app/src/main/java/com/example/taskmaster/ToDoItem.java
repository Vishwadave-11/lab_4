package com.example.taskmaster;

public class ToDoItem {
    private String task;
    private boolean isUrgent;

    public ToDoItem(String task, boolean isUrgent) {
        this.task = task;
        this.isUrgent = isUrgent;
    }

    public String getTask() {
        return task;
    }

    public boolean isUrgent() {
        return isUrgent;
    }
}
