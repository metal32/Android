package com.ayush.tickle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username = (EditText)findViewById(R.id.editText1);
        final EditText password = (EditText)findViewById(R.id.editText2);
        Button button1 = (Button)findViewById(R.id.button1);
        TextView text_view2= (TextView)findViewById(R.id.text_view2);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("ayus097836@gmail.com")&&
                        password.getText().toString().equals("abc123")){
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent select= new Intent(MainActivity.this,SelectInterest.class);
                    startActivity(select);
                } else{ Toast.makeText(getApplicationContext(), "Invalid username or password!"
                        ,Toast.LENGTH_SHORT).show();
                }
            }
        });
        text_view2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent forgotpass=new Intent(MainActivity.this,Forgot_password.class);
                startActivity(forgotpass);
            }
        });


    }
}
