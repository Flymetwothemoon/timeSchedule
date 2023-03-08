package com.example.module_health.Service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.module_health.R;

public class MusicService extends Service {
    private MediaPlayer mMediaPlayer;
    private final IBinder binder = (IBinder) new MusicBinder();



    public class MusicBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }

    public MusicService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //获取MainActivity中 按钮的点击类型：根据不同类型处理不同事件
        String id = intent.getStringExtra("action");
        if(id.equals("oncreate")){
            playMusic();
        }
        if(id.equals("pause")){
            pauseMusic();
        }
        if(id.equals("resume")){
            resumeMusic();
        }
        return super.onStartCommand(intent, flags, startId);
    }
    //开启音乐
    private void playMusic() {
        if(mMediaPlayer==null){
            mMediaPlayer = MediaPlayer.create(this, R.raw.music);
            mMediaPlayer.start();
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SERVICE1","oncreate");
    }
    //暂停音乐
    public void pauseMusic() {
        if (mMediaPlayer.isPlaying()) {
            //当它播放的时候
            mMediaPlayer.pause();
        }
        Log.d("SERVICE1","PAUSEMUSIC");
    }
    //继续播放音乐
    public void resumeMusic() {
        if (!mMediaPlayer.isPlaying()) {
            mMediaPlayer.start();
        }
        Log.d("SERVICE1","RESUMEMUSIC");
    }
    //结束播放音乐

    @Override
    public void onDestroy() {
        super.onDestroy();

        mMediaPlayer.stop();
        mMediaPlayer.reset();
        mMediaPlayer.release();
        if (mMediaPlayer!=null){
            mMediaPlayer = null;
        }
        Log.d("SERVICE1","onDESTORY");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}