package com.example.gradontime.database;

import android.app.Application;

import com.example.gradontime.DAO.AssessmentDAO;
import com.example.gradontime.DAO.CourseDAO;
import com.example.gradontime.DAO.TermDAO;
import com.example.gradontime.obj.Assessment;
import com.example.gradontime.obj.Course;
import com.example.gradontime.obj.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private final TermDAO termDAO;
    private final CourseDAO courseDAO;
    private final AssessmentDAO assessmentDAO;

    private List<Term> allTerms;
    private List<Course> allCourses;
    private List<Assessment> allAssessments;

    private static final int NUM_THREADS = 4;
    static final ExecutorService dbExecutor = Executors.newFixedThreadPool(NUM_THREADS);

    public Repository(Application app) {
        DatabaseBuilder db = DatabaseBuilder.getDatabase(app);
        termDAO = db.termDAO();
        courseDAO = db.courseDAO();
        assessmentDAO = db.assessmentDAO();

        dbExecutor.execute( () -> allTerms = termDAO.getAll() );
        dbExecutor.execute( () -> allCourses = courseDAO.getAll() );
        dbExecutor.execute( () -> allAssessments = assessmentDAO.getAll() );
    }

    public void insertTerm(Term term) {
        // Gets the final Term in the list of terms, adds one to the ID and then sets the term's ID
        // before adding it to the DB.
        if (allTerms.size() > 0) {
            int lastIndex = allTerms.size() - 1;
            int termId = allTerms.get(lastIndex).getTermId() + 1;
            term.setTermId(termId);
        }
        else {
            term.setTermId(1);
        }

        dbExecutor.execute( () -> termDAO.insert(term) );
        allTerms.add(term);
    }

    public void insertCourse(Course course) {
        if (allCourses.size() > 0) {
            int lastIndex = allCourses.size() - 1;
            int courseId = allCourses.get(lastIndex).getCourseId() + 1;
            course.setCourseId(courseId);
        }
        else {
            course.setCourseId(1);
        }

        dbExecutor.execute( () -> courseDAO.insert(course) );

        allCourses.add(course);
    }

    public void insertAssessment(Assessment assessment) {
        if (allAssessments.size() > 0) {
            int lastIndex = allAssessments.size() - 1;
            int assessmentId = allAssessments.get(lastIndex).getAssessmentId() + 1;
            assessment.setAssessmentId(assessmentId);
        }
        else {
            assessment.setAssessmentId(1);
        }

        dbExecutor.execute( () -> assessmentDAO.insert(assessment));

        allAssessments.add(assessment);
    }

    public List<Term> getAllTerms() {
        return allTerms;
    }

    public List<Course> getAllCourses() {
        return allCourses;
    }

    public List<Assessment> getAllAssessments() {
        return allAssessments;
    }
}
