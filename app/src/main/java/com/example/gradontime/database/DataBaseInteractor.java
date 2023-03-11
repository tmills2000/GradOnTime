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

public class DataBaseInteractor {
    private TermDAO termDAO;
    private CourseDAO courseDAO;
    private AssessmentDAO assessmentDAO;

    private List<Term> allTerms;
    private List<Course> allCourses;
    private List<Assessment> allAssessments;

    private static final int NUM_THREADS = 4;
    static final ExecutorService dbExecutor = Executors.newFixedThreadPool(NUM_THREADS);

    public DataBaseInteractor(Application app) {
        DatabaseBuilder db = DatabaseBuilder.getDatabase(app);
        termDAO = db.termDAO();
        courseDAO = db.courseDAO();
        assessmentDAO = db.assessmentDAO();
    }

    public void insertTerm(Term term) {
        dbExecutor.execute( () -> {
            termDAO.insert(term);
        });
    }

    public void getTermId(Term term) {
        dbExecutor.execute( () -> {
            termDAO.get(term.getTermId());
        });
    }

}
