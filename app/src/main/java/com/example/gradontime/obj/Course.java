package com.example.gradontime.obj;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "courses", foreignKeys = {
        @ForeignKey(
                entity = Term.class,
                parentColumns = "termId",
                childColumns = "termId"
        )
})
public class Course extends DatedItem {
    @PrimaryKey(autoGenerate = true)
    private int courseId;
    private int termId;
    private Status status;
    private String note;
    @Ignore
    private ArrayList<Assessment> assessmentList = new ArrayList<>();
    private String instructor;

    public Course() {
        super();
    }

    /**
     * Creates a new course. Status is set to PLANNED and note is set to null by default.
     *
     * @param id        the id of the course.
     * @param title     the title of the course.
     * @param startDate the start date of the course.
     * @param endDate   the end date of the course.
     * @param courseId
     * @param termId
     */
    public Course(int id, String title, String startDate, String endDate, int courseId, int termId, String instructor) {
        super(title, startDate, endDate);
        this.courseId = courseId;
        this.termId = termId;
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
    public String getInstructor() {
        return instructor;
    }

    /**
     * Sets the instructor of the course. This may not be used ever.
     * @param instructor the instructor to set.
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }
}
