package com.example.module_health.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;

import com.example.module_health.R;

public class MusicService extends Service {
    MediaPlayer mMediaPlayer;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this, R.raw.music);
        mMediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
        if (mMediaPlayer!=null){
            mMediaPlayer = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}