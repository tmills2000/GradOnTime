package com.example.gradontime.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gradontime.R;
import com.example.gradontime.database.Repository;
import com.example.gradontime.obj.Term;

import java.time.format.DateTimeFormatter;

public class AddTerm extends AppCompatActivity {

    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dated_obj);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        repo = new Repository(getApplication());
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /**
     * TODO: Needs error validation for date pattern.
     * TODO: Auto-input a forward slash after entering numbers.
     * Good guide for text input <a href="https://guides.codepath.com/android/Working-with-the-EditText">here</a>
     * @param view
     */
    public void onSaveClick(View view) {
        EditText titleEditor = findViewById(R.id.titleInput);
        EditText startDateEditor = findViewById(R.id.startDateInput);
        EditText endDateEditor = findViewById(R.id.endDateInput);

        String title = titleEditor.getText().toString();
        String startDate = startDateEditor.getText().toString();
        String endDate = endDateEditor.getText().toString();

        Term newTerm = new Term(title, startDate, endDate);
        repo.insertTerm(newTerm);
    }
}