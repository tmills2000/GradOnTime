package com.example.gradontime.obj;

import java.time.LocalDate;

public class Assessment extends DatedItem {
    Assessment(String title, LocalDate startDate, LocalDate endDate) {
        super(title, startDate, endDate);
    }
}
