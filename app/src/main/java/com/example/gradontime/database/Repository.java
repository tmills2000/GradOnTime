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
    private TermDAO termDAO;
    private CourseDAO courseDAO;
    private AssessmentDAO assessmentDAO;

    private static List<Term> allTerms;
    private static List<Course> allCourses;
    private static List<Assessment> allAssessments;

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
        int lastIndex = allTerms.size() - 1;
        int termId = allTerms.get(lastIndex).getTermId() + 1;
        term.setTermId(termId);

        dbExecutor.execute( () -> termDAO.insert(term) );

        allTerms.add(term);
    }

    public void insertCourse(Course course) {
        int lastIndex = allCourses.size() - 1;
        int courseId = allCourses.get(lastIndex).getCourseId() + 1;
        course.setCourseId(courseId);

        dbExecutor.execute( () -> courseDAO.insert(course) );

        allCourses.add(course);
    }

    public void insertAssessment(Assessment assessment) {
        int lastIndex = allAssessments.size() - 1;
        int assessmentId = allAssessments.get(lastIndex).getAssessmentId() + 1;
        assessment.setAssessmentId(assessmentId);

        dbExecutor.execute( () -> assessmentDAO.insert(assessment));

        allAssessments.add(assessment);
    }

}
