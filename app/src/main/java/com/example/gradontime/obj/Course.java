package com.example.gradontime.obj;

import java.time.LocalDate;

enum Status {
    PLANNED,
    CURRENT,
    COMPLETE,
    DROPPED;
}

public class Course extends Todo {
    private Status status;
    Course(String title, LocalDate startDate, LocalDate endDate) {
        super(title, startDate, endDate);
    }
}
