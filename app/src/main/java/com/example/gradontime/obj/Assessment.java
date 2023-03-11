package com.example.gradontime.obj;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assessments")
public class Assessment extends DatedItem {
    @PrimaryKey(autoGenerate = true)
    private int assessmentId;

    public Assessment() {

    }

    Assessment(String title, String startDate, String endDate, int assessmentId) {
        super(title, startDate, endDate);
        this.assessmentId = assessmentId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }
}
