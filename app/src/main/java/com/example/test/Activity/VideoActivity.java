package com.example.test.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.test.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {

    private JZVideoPlayerStandard video_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();

        String videoUrl = getIntent().getStringExtra("url");
        video_player.setUp(videoUrl, JZVideoPlayer.SCREEN_WINDOW_NORMAL,"农技耘");
        video_player.startVideo();
    }
    private void initView() {
        video_player = findViewById(R.id.video_player);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayerStandard.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
}
