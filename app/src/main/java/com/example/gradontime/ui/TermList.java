package com.example.gradontime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradontime.R;

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
    }
    public void onAddClick(View view) {
//        setContentView(R.layout.activity_add_dated_obj);

        Intent intent = new Intent(this, AddTerm.class);
        startActivity(intent);
    }
}