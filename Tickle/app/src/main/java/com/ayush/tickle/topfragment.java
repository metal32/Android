package com.ayush.tickle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.BaseBundle;
import android.support.v4.app.Fragment;


public class topfragment extends Fragment{

    private static EditText text_box1;
    private static EditText text_box2;
    private static Button meme_button;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void creatememe(String top, String bottom);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCommander=(TopSectionListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.top_section_fragment,container,false);

        text_box1 = (EditText)view.findViewById(R.id.text_box1);
        text_box2 = (EditText)view.findViewById(R.id.text_box2);
        meme_button =(Button)view.findViewById(R.id.meme_button);

        meme_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                buttonClicked(v);
            }

        });

        return view;
    }

    public void buttonClicked(View view){
        activityCommander.creatememe(text_box1.getText().toString(),text_box2.getText().toString());

    }



}
