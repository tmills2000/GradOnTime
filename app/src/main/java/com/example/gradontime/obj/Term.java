package com.example.gradontime.obj;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity(tableName = "terms")
public class Term extends DatedItem {
    @PrimaryKey(autoGenerate = true)
    private int termId;
    private ArrayList<Course> courseList = new ArrayList<>();
    public Term(String title, LocalDate startDate, LocalDate endDate) {
        super(title, startDate, endDate);
    }

    @Override
    public String toString() {
        String concat = null;
        concat = "Title: " + title + "\nStart: " + startDate.toString() + "\nEnd: " + endDate.toString();
        return concat;
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
