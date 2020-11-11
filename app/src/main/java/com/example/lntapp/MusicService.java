package com.example.lntapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service {
    MediaPlayer mediaPlayer ;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Service Created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_SHORT).show();
//        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.music);
        mediaPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        mediaPlayer = MediaPlayer.create(this,R.raw.music);
        mediaPlayer.start();
        return START_STICKY;
    }
}