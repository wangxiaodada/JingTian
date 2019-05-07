package com.example.jingtian;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.PlayViewHolder> {


    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public PlayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到频道行对应的xml，并将其“反析”出来（inflate）
        View container =  LayoutInflater.from(parent.getContext()).inflate(
                R.layout.play_view,parent,false);
        return new PlayViewHolder(container);
    }

    /**
     * 填充每一行内容，此时暂时硬编码，让所有行内容相同
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull PlayViewHolder holder, int position) {
        String name="美丽心灵";
        holder.bind(name);

    }

    /**
     * 表示列表行数，此处暂时硬编码为5行
     * @return
     */
    @Override
    public int getItemCount() {
        return 5;
    }

    //内部类，应与播放刚布局XML对应
    public  class PlayViewHolder extends RecyclerView.ViewHolder {
        private TextView playName;
        public PlayViewHolder(View container){
            super(container);
            playName = container.findViewById(R.id.play_name);

        }

        /**
         * 把传入的值显示到对应的控件上
         * @param playName
         */
        public void bind(String playName){
            this.playName.setText(playName);
        }

    }
}
