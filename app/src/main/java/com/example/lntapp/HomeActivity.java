package com.example.lntapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String data = extras.getString("userName");
        TextView view = findViewById(R.id.showUserName);
        view.setText("Hello, "+data);
    }
}