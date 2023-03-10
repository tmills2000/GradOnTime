package com.example.gradontime.obj;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "assessments")
public class Assessment extends DatedItem {
    @PrimaryKey(autoGenerate = true)
    private int assessmentId;

    Assessment(String title, LocalDate startDate, LocalDate endDate) {
        super(title, startDate, endDate);
    }
}
