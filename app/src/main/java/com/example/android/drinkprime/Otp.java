package com.example.android.drinkprime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Otp extends AppCompatActivity implements View.OnClickListener{

    TextView setNumber;
    EditText otp;
    Button   submit;
    Button   changeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        setNumber    = (TextView) findViewById(R.id.textView_setnumber);
        otp          = (EditText) findViewById(R.id.editText_otp);
        submit       = (Button) findViewById(R.id.button_submit);
        changeNumber = (Button) findViewById(R.id.button_changeNumber);
        submit.setOnClickListener(this);
        changeNumber.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_submit: {
                Intent goto_final = new Intent(this, Final.class);
                startActivity(goto_final);
                break;
            }
            case R.id.button_changeNumber: {
                Intent goto_login = new Intent(this, Login.class);
                startActivity(goto_login);
                break;
            }
        }
    }

}
