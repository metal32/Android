package com.ayush.tickle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


public class SelectInterest extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_interest);

        final ImageView image1= (ImageView)findViewById(R.id.image1);
        final ImageView image2= (ImageView)findViewById(R.id.image2);
        final ImageView image3= (ImageView)findViewById(R.id.image3);
        final ImageView image4= (ImageView)findViewById(R.id.image4);
        final ImageView image5= (ImageView)findViewById(R.id.image5);
        final ImageView image6= (ImageView)findViewById(R.id.image6);

        image1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image1.setImageResource(R.drawable.check_button_2);
            }
        });
        image2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image2.setImageResource(R.drawable.check_button_2);
            }
        });
        image3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image3.setImageResource(R.drawable.check_button_2);
            }
        });
        image4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image4.setImageResource(R.drawable.check_button_2);
            }
        });
        image5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image5.setImageResource(R.drawable.check_button_2);
            }
        });
        image6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image6.setImageResource(R.drawable.check_button_2);
            }
        });
    }
}
