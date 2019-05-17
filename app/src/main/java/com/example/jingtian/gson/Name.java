package com.example.jingtian.gson;

import android.annotation.SuppressLint;
import androidx.core.app.ComponentActivity;

@SuppressLint("RestrictedApi")
public class Name extends ComponentActivity {
    private int cannalId;
    private String cannalName;
    public int getCannaId(){
        return cannalId;
    }
    public void setCannaId(int id){
        this.cannalId = cannalId;
    }
    public String getCannalName(){
        return cannalName;
    }
    public void setCannalName(String name){
        this.cannalName = cannalName;
    }

}
