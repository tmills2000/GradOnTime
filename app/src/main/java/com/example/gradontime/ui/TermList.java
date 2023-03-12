package com.example.gradontime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradontime.R;
import com.example.gradontime.database.Repository;
import com.example.gradontime.obj.Term;

import java.util.List;

public class TermList extends AppCompatActivity {
    private List<Term> terms;
    private final TextView placeHolder = findViewById(R.id.placeholder_text);
    private final RecyclerView termRecycler = findViewById(R.id.termRecyclerView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        Repository repo = new Repository(getApplication());
        terms = repo.getAllTerms();
        if (terms != null) {
            placeHolder.setVisibility(View.INVISIBLE);
            termRecycler.setVisibility(View.VISIBLE);
        }
        for (Term term : terms) {

        }

    }
    public void onAddClick(View view) {
//        setContentView(R.layout.activity_add_dated_obj);

        Intent intent = new Intent(this, AddTerm.class);
        startActivity(intent);
    }
}