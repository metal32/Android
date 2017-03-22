package com.ayush.tickle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;


public class SelectInterest extends AppCompatActivity{
    public static int str=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_interest);

        Toolbar toolbar1=(Toolbar) findViewById(R.id.toolbar1);
        toolbar1.setTitle("Select your interests");
        setSupportActionBar(toolbar1);

        final ImageView image1= (ImageView)findViewById(R.id.image1);
        final ImageView image2= (ImageView)findViewById(R.id.image2);
        final ImageView image3= (ImageView)findViewById(R.id.image3);
        final ImageView image4= (ImageView)findViewById(R.id.image4);
        final ImageView image5= (ImageView)findViewById(R.id.image5);
        final ImageView image6= (ImageView)findViewById(R.id.image6);
        final ImageView image7= (ImageView)findViewById(R.id.image7);
        final ImageView image8= (ImageView)findViewById(R.id.image8);
        final ImageView image9= (ImageView)findViewById(R.id.image9);
        final ImageView image10= (ImageView)findViewById(R.id.image10);
        final ImageView image11= (ImageView)findViewById(R.id.image11);
        final ImageView image12= (ImageView)findViewById(R.id.image12);
        final Button footer=(Button)findViewById(R.id.footer);

        image1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //image1.setImageResource(R.drawable.check_button_2);
                image7.setVisibility(4-image7.getVisibility());
                if(image7.getVisibility()==View.VISIBLE) {
                    str=str+1;
                }
                else{
                    str=str-1;
                }
                if (str!=0){
                    footer.setText(Integer.toString(str)+" Selected, Done!");
                }
                else{
                    footer.setText("Done!");
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image8.setVisibility(4-image8.getVisibility());
                if(image8.getVisibility()==View.VISIBLE) {
                    str=str+1;
                }
                else{
                    str=str-1;
                }
                if (str!=0){
                    footer.setText(Integer.toString(str)+" Selected, Done!");
                }
                else{
                    footer.setText("Done!");
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image9.setVisibility(4-image9.getVisibility());
                if(image9.getVisibility()==View.VISIBLE) {
                    str=str+1;
                }
                else{
                    str=str-1;
                }
                if (str!=0){
                    footer.setText(Integer.toString(str)+" Selected, Done!");
                }
                else{
                    footer.setText("Done!");
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image10.setVisibility(4-image10.getVisibility());
                if(image10.getVisibility()==View.VISIBLE) {
                    str=str+1;
                }
                else{
                    str=str-1;
                }
                if (str!=0){
                    footer.setText(Integer.toString(str)+" Selected, Done!");
                }
                else{
                    footer.setText("Done!");
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image11.setVisibility(4-image11.getVisibility());
                if(image11.getVisibility()==View.VISIBLE) {
                    str=str+1;
                }
                else{
                    str=str-1;
                }
                if (str!=0){
                    footer.setText(Integer.toString(str)+" Selected, Done!");
                }
                else{
                    footer.setText("Done!");
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                image12.setVisibility(4-image12.getVisibility());
                if(image12.getVisibility()==View.VISIBLE) {
                    str=str+1;
                }
                else{
                    str=str-1;
                }
                if (str!=0){
                    footer.setText(Integer.toString(str)+" Selected, Done!");
                }
                else{
                    footer.setText("Done!");
                }
            }
        });
        footer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent end =new Intent(SelectInterest.this, Final.class);
                startActivity(end);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.file1,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id=item.getItemId();
        if (res_id==R.id.action_favorite){
            Intent next = new Intent(SelectInterest.this,Final.class);
            startActivity(next);
        }
        return true;
    }

}
