package com.example.gradontime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradontime.R;
import com.example.gradontime.database.Repository;
import com.example.gradontime.obj.Term;

import java.util.List;

public class TermList extends AppCompatActivity {
    private List<Term> terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        Repository repo = new Repository(getApplication());
        terms = repo.getAllTerms();
        for (Term term : terms) {

        }

    }
    public void onAddClick(View view) {
//        setContentView(R.layout.activity_add_dated_obj);

        Intent intent = new Intent(this, AddTerm.class);
        startActivity(intent);
    }
}