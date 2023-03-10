package com.example.gradontime.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gradontime.DAO.AssessmentDAO;
import com.example.gradontime.DAO.CourseDAO;
import com.example.gradontime.DAO.TermDAO;
import com.example.gradontime.obj.Assessment;
import com.example.gradontime.obj.Course;
import com.example.gradontime.obj.Term;

@Database(entities = {Term.class, Course.class, Assessment.class}, version = 1, exportSchema = false)
public abstract class DatabaseBuilder extends RoomDatabase {
    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    public abstract AssessmentDAO assessmentDAO();

    private static volatile DatabaseBuilder INSTANCE;

    static DatabaseBuilder getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (DatabaseBuilder.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseBuilder.class, "gradDatabase")
                        .fallbackToDestructiveMigration()
                        .build();
            }

        }
        return INSTANCE;
    }

}
