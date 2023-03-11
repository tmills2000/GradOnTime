package com.example.gradontime.obj;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "terms")
public class Term extends DatedItem {
    @PrimaryKey(autoGenerate = true)
    private int termId;
    @Ignore
    private ArrayList<Course> courseList = new ArrayList<>();

    public Term() {

    }
    @Ignore
    public Term(String title, String startDate, String endDate) {
        super(title, startDate, endDate);
    }

    public Term(int termId, String title, String startDate, String endDate) {
        this(title, startDate, endDate);
        this.termId = termId;
    }

    @Override
    public String toString() {
        String concat = null;
        concat = "Title: " + title + "\nStart: " + startDate.toString() + "\nEnd: " + endDate.toString();
        return concat;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getTermId() {
        return termId;
    }

    /**
     * Adds a course to the list of courses associated with the Term object.
     * @param course the course to add.
     */
    public void addCourse(Course course) {
        courseList.add(course);
    }

    /**
     * Removes a course from the list of courses associated with the Term object.
     * @param course the course to remove.
     */
    public void removeCourse(Course course) {
        courseList.remove(course);
    }
}
