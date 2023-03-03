package com.example.gradontime.obj;

import java.time.LocalDate;
import java.util.ArrayList;

enum Status {
    PLANNED,
    CURRENT,
    COMPLETE,
    DROPPED;
}

public class Course extends Todo {
    private Status status;
    private ArrayList<Assessment> assessmentList = new ArrayList<>();

    /**
     * Creates a new course. Status is set to Status.PLANNED by default.
     * @param title the title of the course.
     * @param startDate the start date of the course.
     * @param endDate the end date of the course.
     */
    Course(String title, LocalDate startDate, LocalDate endDate) {
        super(title, startDate, endDate);
        status = Status.PLANNED;
    }

    /**
     * Adds a newly created assessment to the assessment list.
     * @param assessment the assessment to add.
     */
    public void addAssessment(Assessment assessment) {
        assessmentList.add(assessment);
    }

    /**
     * Removes an assessment from the assessment list.
     * @param assessment the assessment to remove.
     */
    public void removeAssessment(Assessment assessment) {
        assessmentList.remove(assessment);
    }

    /**
     * Gets the status of the course.
     * @return  either PLANNED, CURRENT, COMPLETE or DROPPED
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of the course.
     * @param status either PLANNED, CURRENT, COMPLETED or DROPPED
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Checks to see if the list of assessments associated with this course is empty.
     * @return true if the list of assessments is empty, false otherwise.
     */
    public boolean hasAppointments() {
        return assessmentList.isEmpty();
    }
}
