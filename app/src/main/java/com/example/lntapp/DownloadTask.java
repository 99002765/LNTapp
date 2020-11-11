package com.example.lntapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

public class DownloadTask extends AsyncTask<String,Integer,Void> {//input type,progress type,result type

    private static final String TAG = DownloadTask.class.getSimpleName();
    ProgressBar mProgressBar;
    public DownloadTask(ProgressBar progressBar) {
        mProgressBar= progressBar;
    }

    /**
     * This method will run on a background thread.
     * @param strings
     * @return
     */
    @Override
    protected Void doInBackground(String... strings) {
        Log.i(TAG, strings[0]);
        publishProgress(50);
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mProgressBar.setProgress(values[0]);
    }
}
