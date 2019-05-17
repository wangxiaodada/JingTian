package com.example.jingtian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView playList;
    private PlayListAdapter playAdapter;
    private List<Channel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);
        initData();

        playList=findViewById(R.id.playList);
        playAdapter = new PlayListAdapter(this.data,new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (position < data.size()){
                    Channel c = data.get(position);
                    Intent intent = new Intent(MainActivity.this,BoFang.class);
                    intent.putExtra("channel",c);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"无效频道",Toast.LENGTH_SHORT);
                }
            }
        });
        playList.setLayoutManager(new LinearLayoutManager(this));
        playList.setAdapter(playAdapter);

//        playAdapter.setOnItemClickListener(this.data,new PlayListAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(MainActivity.this,BoFang.class);
//                intent.putExtra("name",PlayLab.getP().getPlay(position));
//                intent.putExtra("mUri",UriLab.getU().getUris(position).toString());
//                //intent.putExtra("position",position);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });


    }

    private void initData(){
        DataLab lab = new DataLab(this);
        this.data = lab.getChannels("play_uri.json");
    }
    
}
