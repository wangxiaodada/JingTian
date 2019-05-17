package com.example.jingtian;


import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Log;

public class BoFang  extends AppCompatActivity {

    private String TAG = "";
    private PlayerView playerView;
   private SimpleExoPlayer player;;
    private ImageView ibn;
    private TextView textView;
    private Button btn1;
    private Channel channel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bofang);
//        Intent intent =getIntent();
//        String name = intent.getStringExtra("name");
//        Uri mUri = Uri.parse(intent.getStringExtra("mUri"));
//        Uri uri = Uri.parse("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8");
        channel = (Channel)getIntent().getSerializableExtra("channel");



        playerView =  findViewById(R.id.playerView);
        player = ExoPlayerFactory.newSimpleInstance(this);
        player.setPlayWhenReady(true);
        playerView.setPlayer(player);
        DataSource.Factory factory = new DefaultDataSourceFactory(this,"J");
        MediaSource mediaSource = new HlsMediaSource.Factory(factory).createMediaSource(mUri(channel.getUrl()));

        player.prepare(mediaSource);






        textView = findViewById(R.id.tv_name);
        textView.setText(name(channel.getTitle()));

        ibn = findViewById(R.id.ibn1);
        ibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn1 = findViewById(R.id.btn_full);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });
    }
    private Uri mUri(String url) {
        return Uri.parse(channel.getUrl());
    }
    private String name(String name){
        return channel.getTitle();
    }
    @Override
    protected void onResume(){
        super.onResume();
        releasePlayer();
        Log.i(TAG,"onresume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        releasePlayer();
        Log.i(TAG,"onpause");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"ondestroy");
        releasePlayer();
    }

    private void releasePlayer(){
        if (player != null){
            player.release();
            player = null;
        }
    }



}

