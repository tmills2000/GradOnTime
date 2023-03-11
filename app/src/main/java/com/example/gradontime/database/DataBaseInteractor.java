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

        dbExecutor.execute( () -> allTerms = termDAO.getAll());
    }

    public void insertTerm(Term term) {
        // Gets the final Term in the list of terms, adds one to the ID and then sets the term's ID
        // before adding it to the DB.
        int lastIndex = allTerms.size();
        int termId = allTerms.get(lastIndex - 1).getTermId() + 1;
        term.setTermId(termId);

        dbExecutor.execute( () -> {
            termDAO.insert(term);
        });

        allTerms.add(term);
    }

}
