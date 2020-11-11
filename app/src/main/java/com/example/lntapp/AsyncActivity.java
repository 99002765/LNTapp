package com.example.lntapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar progressBar;
    private static final String TAG = AsyncActivity.class.getSimpleName();
    EditText editText;
    TextView author,title;
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
    public void searchBooks(View view){

    }

    public void serviceHandler(View view) {
        Intent serviceIntent = new Intent(AsyncActivity.this,MusicService.class);
        switch(view.getId()){
            case R.id.buttonStart:
//                start music
                Log.i(TAG, "start");
                startService(serviceIntent);
                break;
            case R.id.buttonStop:
//                stop music
                stopService(serviceIntent);
                break;
        }
    }
}