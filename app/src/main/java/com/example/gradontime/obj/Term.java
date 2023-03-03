package com.example.gradontime.obj;

import java.time.LocalDate;

public class Term extends Todo{
    private
    Term(String title, LocalDate startDate, LocalDate endDate) {
        super(title, startDate, endDate);
    }
}
