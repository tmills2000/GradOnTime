package com.example.gradontime.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gradontime.R;
import com.example.gradontime.obj.Term;

import java.time.LocalDate;

public class AddTerm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dated_obj);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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

    public void onSaveClick(View view) {
        EditText titleEditor = findViewById(R.id.titleInput);
        EditText startDateEditor = findViewById(R.id.startDateInput);
        EditText endDateEditor = findViewById(R.id.endDateInput);

        String title = titleEditor.getText().toString();
        LocalDate startDate = LocalDate.parse(startDateEditor.getText().toString());
        LocalDate endDate = LocalDate.parse(endDateEditor.getText().toString());

        Term newTerm = new Term(title, startDate, endDate);
        System.out.println(newTerm);
    }
}