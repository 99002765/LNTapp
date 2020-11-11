package com.example.lntapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
    String[] languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        languages=new String[]{"Hindi","Telugu","Tamil","Malayalam"};
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        MyAdapter adapter = new MyAdapter(this,languages);
        StaggeredGridLayoutManager staggeredGridLayoutManager= new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}