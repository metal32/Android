package com.ayush.tickle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Meme extends AppCompatActivity implements topfragment.TopSectionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);
    }

    // This gets call when user click the buttom
    @Override
    public void creatememe(String top, String bottom){
        bottomFragment bfragment=(bottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bfragment.setMemeText(top,bottom);

    }
}
