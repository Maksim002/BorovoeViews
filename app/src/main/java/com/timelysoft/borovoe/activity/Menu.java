package com.timelysoft.borovoe.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.timelysoft.borovoe.R;

import java.io.IOException;

public class Menu extends AppCompatActivity implements SurfaceHolder.Callback{

    private static final String TAG = "___________";
    private SurfaceView surfaceView;
    private MediaPlayer media = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        media = new MediaPlayer();
        surfaceView = findViewById(R.id.video_bg);
        surfaceView.getHolder().addCallback(this);
        media.start();
        media.setLooping(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        media.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        media.stop();
        media.start();
        }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.intro);

        try {
            media.setDataSource(this, video);
            media.prepare();
        } catch (IOException ex) {
            Log.e(TAG, "Surface created");
        }

        //Get the dimensions of the video
        int videoHeight = media.getVideoHeight()+40;

        //Get the width of the screen
        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();

        //Get the SurfaceView layout parameters
        android.view.ViewGroup.LayoutParams lp = surfaceView.getLayoutParams();

        //Set the width of the SurfaceView to the width of the screen
        lp.height = screenHeight;

        //Set the height of the SurfaceView to match the aspect ratio of the video
        //be sure to cast these as floats otherwise the calculation will likely be 0
        lp.width = (int) (((float)screenHeight / (float)videoHeight) * (float)screenHeight);

        //Commit the layout parameters
        surfaceView.setLayoutParams(lp);

        //Start video
        media.setDisplay(holder);
        media.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }


}
