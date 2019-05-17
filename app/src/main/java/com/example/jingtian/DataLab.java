package com.example.jingtian;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataLab {
    private Context context;
    public DataLab(Context ctx){
        context = ctx;
    }
    public String loadJSONFromAsset(String filename){
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
    public List<Channel> getChannels(String filename){
    List<Channel> result = new ArrayList<>();
    String json = loadJSONFromAsset(filename);
    try {
        JSONObject obj = new JSONObject(json);
        JSONArray data = obj.getJSONArray("data");
        for (int i = 0;i < data.length(); i++){
            Channel c = new Channel();
            JSONObject item = data.getJSONObject(i);
            c.setTitle(item.getString("title"));
            c.setUrl(item.getString("url"));
            c.setImgUrl(item.getString("logo"));
            result.add(c);
        }

        } catch (JSONException e) {
        e.printStackTrace();
    }
    return result;
    }
}
