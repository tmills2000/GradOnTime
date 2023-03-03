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
    private String note;
    private ArrayList<Assessment> assessmentList = new ArrayList<>();
    private Instructor instructor;

    /**
     * Creates a new course. Status is set to Status.PLANNED and note is set to null by default.
     * @param title the title of the course.
     * @param startDate the start date of the course.
     * @param endDate the end date of the course.
     */
    Course(String title, LocalDate startDate, LocalDate endDate, Instructor instructor) {
        super(title, startDate, endDate);
        this.instructor = instructor;
        status = Status.PLANNED;
        note = null;
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

    /**
     * Gets the note that was set on the Course object.
     * @return the note if one is set, null if not set.
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the note on the Course object.
     * @param note the note to set.
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Gets the instructor of the course.
     * @return the instructor of the course.
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Sets the instructor of the course. This may not be used ever.
     * @param instructor the instructor to set.
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
