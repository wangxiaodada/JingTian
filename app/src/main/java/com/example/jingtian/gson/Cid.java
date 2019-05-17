package com.example.jingtian.gson;

import android.annotation.SuppressLint;
import androidx.core.app.ComponentActivity;

@SuppressLint("RestrictedApi")
public class Cid extends ComponentActivity {
    private int id;
    private String cUrl;

    public int getId() {
        return id;
    }
    public void setId(){
        this.id = id;
    }
    public String getCurl(){
        return cUrl;
    }
    public void setcUrl(){
        this.cUrl =cUrl;
    }
}
