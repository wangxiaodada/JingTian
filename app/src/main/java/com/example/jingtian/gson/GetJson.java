package com.example.jingtian.gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetJson {
    public static boolean aaa(String b){
        try {
            JSONArray allName = new JSONArray(b);
            for (int i = 0;i<allName.length();i++){
                JSONObject nameObject = allName.getJSONObject(i);
                Name name = new Name();
                name.setCannalName(nameObject.getString("name"));
                name.setCannaId(nameObject.getInt("id"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }return false;
    }
}
