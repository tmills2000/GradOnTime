package com.example.gradontime.obj;

import java.time.LocalDate;
import java.util.ArrayList;

public class Term extends Todo{
    private ArrayList<Course> courseList = new ArrayList<>();
    private
    Term(String title, LocalDate startDate, LocalDate endDate) {
        super(title, startDate, endDate);
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
