package com.example.gradontime.obj;

import java.time.LocalDate;

public abstract class Todo {
    protected LocalDate startDate, endDate;
    protected String title;
    Todo(String title, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
