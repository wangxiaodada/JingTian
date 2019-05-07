package com.example.jingtian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView playList;
    private PlayListAdapter playAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_List);

        playList=findViewById(R.id.playList);
        playAdapter=new PlayListAdapter();
        playList.setLayoutManager(new LinearLayoutManager(this));
        playList.setAdapter(playAdapter);
    }
}
