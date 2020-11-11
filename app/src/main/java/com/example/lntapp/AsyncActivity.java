package com.example.lntapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar progressBar;
    private static final String TAG = AsyncActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        progressBar = findViewById(R.id.progressBar);
    }
    public void handleClick(View view){
//        download something from internet
        Log.i(TAG, "handleClick");
        DownloadTask downloadTask = new DownloadTask(progressBar);
        downloadTask.execute("https://urlForimageTobedownloaded");
//        show the download progress on progress bar
    }
}