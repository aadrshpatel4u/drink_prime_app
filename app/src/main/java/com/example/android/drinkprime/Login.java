package com.example.android.drinkprime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText number2;
    Button   log_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        number2 = (EditText) findViewById(R.id.editText_number2);
        log_in   = (Button) findViewById(R.id.button_login);

        log_in.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent goto_otp = new Intent(this, Otp.class);
        startActivity(goto_otp);

    }
            }
