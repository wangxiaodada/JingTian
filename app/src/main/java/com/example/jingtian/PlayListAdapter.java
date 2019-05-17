package com.example.jingtian;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;



public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.PlayViewHolder> {


    private List<Channel> channels;
    private Context context;
    private OnItemClickListener listener;
    public PlayListAdapter(List<Channel> channels, OnItemClickListener listener){
        this.listener = listener;
        this.channels = channels;
    }

    @NonNull
    @Override
    public PlayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View container =  LayoutInflater.from(parent.getContext()).inflate(
                R.layout.play_view,parent,false);
        PlayViewHolder holder = new PlayViewHolder(container);
        container.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                listener.onClick(v,holder.getLayoutPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayViewHolder holder, int position) {
        holder.bind(context,channels.get(position));
    }
    @Override
    public int getItemCount() {
        return channels.size();
    }


    public static class PlayViewHolder extends RecyclerView.ViewHolder {
        private ImageView logo;
        private TextView playName;
        public PlayViewHolder(View container){
            super(container);
            playName = container.findViewById(R.id.play_name);
            logo = container.findViewById(R.id.iv_view);
        }
        public void bind(Context context,Channel c){
            playName.setText(c.getTitle());
            Glide.with(context).load(c.getImgUrl()).into(logo);

        }
    }



}
