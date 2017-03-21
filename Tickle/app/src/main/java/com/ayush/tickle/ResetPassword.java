package com.ayush.tickle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        final EditText otp = (EditText)findViewById(R.id.editText5);
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (otp.getText().toString().equals("12345")) {
                    Toast.makeText(getApplicationContext(),
                            "Done", Toast.LENGTH_SHORT).show();
                    Intent main= new Intent(ResetPassword.this,MainActivity.class);
                    startActivity(main);
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "Wrong OTP", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
